package com.patochallen.permissions.model

import android.app.Activity
import android.content.Context
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
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

    val launcher = rememberLauncherPermissionForResult()

    val permissionState = remember(permission) {
        MutablePermissionState(
            permission = permission,
            context = context,
            activity = context.findActivity(),
            launcher = launcher
        )
    }

    CheckLifecycleResumeEventEffect {
        if (permissionState.status != PermissionStatus.Granted) {
            permissionState.refreshPermissionStatus()
        }
    }

    return permissionState
}

/**
 * A mutable state object that control and observe if the [PermissionStatus] for the requested [permission] has changed.
 *
 * @param permission the permission to check.
 * @param context is required to check if the requested [permission] is granted.
 * @param activity is required to check if it is necessary to show a rationale for the requested [permission] to the user.
 * @param launcher the [ActivityResultLauncher] that can be used to start the activity.
 */
@ExperimentalApi
@Stable
internal class MutablePermissionState(
    override val permission: String,
    private val context: Context,
    private val activity: Activity,
    private val launcher: ActivityResultLauncher<String>
) : PermissionState {

    override var status: PermissionStatus by mutableStateOf(getPermissionStatus())

    override fun requestPermission() {
        launcher.launch(permission)
    }

    internal fun refreshPermissionStatus() {
        status = getPermissionStatus()
    }

    private fun hasPermission(): Boolean = context.checkPermission(permission)
        .also { hasPermission ->
            if (hasPermission) {
                setRationalViewed(false)
            }
        }

    private fun shouldShowRational(): Boolean = activity.shouldShowRationale(permission)
        .also { shouldShowRational ->
            if (shouldShowRational) {
                setRationalViewed(true)
            }
        }

    private fun hasRationalViewed(): Boolean = activity
        .getPreferences(Context.MODE_PRIVATE)
        .getBoolean(permission, false)

    private fun setRationalViewed(hasViewed: Boolean) = activity
        .getPreferences(Context.MODE_PRIVATE)
        .edit()
        .putBoolean(permission, hasViewed)
        .apply()

    private fun getPermissionStatus(): PermissionStatus = when {
        hasPermission() -> PermissionStatus.Granted
        shouldShowRational() || hasRationalViewed().not() -> PermissionStatus.ShowRational
        else -> PermissionStatus.Denied
    }
}
