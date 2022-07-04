package com.patochallen.permissions.model

import android.app.Activity
import android.content.Context
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle.Event.ON_RESUME
import androidx.lifecycle.LifecycleEventObserver
import com.patochallen.permissions.utils.checkPermission
import com.patochallen.permissions.utils.findActivity
import com.patochallen.permissions.utils.shouldShowRationale

/**
 * remember the [MutablePermissionState] across compositions.
 *
 * @param permission the permission to check.
 * @return a [MutablePermissionState]
 */
@ExperimentalApi
@Composable
internal fun rememberMutablePermissionState(
    permission: String,
): MutablePermissionState {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val permissionState: MutablePermissionState = remember(permission) {
        MutablePermissionState(
            permission = permission,
            context = context,
            activity = context.findActivity()
        )
    }

    val lifecycleObserver: LifecycleEventObserver = remember(permissionState) {
        LifecycleEventObserver { _, event ->
            if (event == ON_RESUME && permissionState.status != PermissionStatus.Granted) {
                permissionState.refreshPermissionStatus()
            }
        }
    }

    val launcher: ManagedActivityResultLauncher<String, Boolean> =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
            permissionState.refreshPermissionStatus()
        }

    DisposableEffect(lifecycle, permissionState) {
        lifecycle.addObserver(lifecycleObserver)

        onDispose { lifecycle.removeObserver(lifecycleObserver) }
    }

    DisposableEffect(permissionState, launcher) {
        permissionState.launcher = launcher

        onDispose { permissionState.launcher = null }
    }

    return permissionState
}

/**
 * A mutable state object that control and observe if the [PermissionStatus] for the requested [permission] has changed.
 *
 * @param permission the permission to check.
 * @param context is required to check if the requested [permission] is granted.
 * @param activity is required to check if it is necessary to show a rationale
 * for the requested [permission] to the user.
 */
@ExperimentalApi
@Stable
internal class MutablePermissionState(
    override val permission: String,
    private val context: Context,
    private val activity: Activity
) : PermissionState {

    override var status: PermissionStatus by mutableStateOf(getPermissionStatus())

    override fun requestPermission() {
        launcher?.launch(
            permission
        )
    }

    internal var launcher: ActivityResultLauncher<String>? = null

    internal fun refreshPermissionStatus() {
        status = getPermissionStatus()
    }

    private fun hasPermission(): Boolean =
        context.checkPermission(permission)
            .also { hasPermission ->
                if (hasPermission) {
                    setRationalViewed(false)
                }
            }

    private fun shouldShowRational(): Boolean =
        activity.shouldShowRationale(permission)
            .also { shouldShowRational ->
                if (shouldShowRational) {
                    setRationalViewed(true)
                }
            }

    private fun hasRationalViewed(): Boolean = activity
        .getPreferences(Context.MODE_PRIVATE)
        .getBoolean(permission, false)

    private fun setRationalViewed(hasViewed: Boolean) {
        activity
            .getPreferences(Context.MODE_PRIVATE)
            .edit()
            .putBoolean(permission, hasViewed)
            .apply()
    }

    private fun getPermissionStatus(): PermissionStatus {
        return when {
            hasPermission() -> PermissionStatus.Granted
            shouldShowRational() || hasRationalViewed().not() -> PermissionStatus.ShowRational
            else -> PermissionStatus.Denied
        }
    }
}
