package com.patochallen.permissions.model

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.PermissionStatus.Denied
import com.google.accompanist.permissions.PermissionStatus.Granted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.patochallen.permissions.utils.findActivity

/**
 * remember the [MutableSavedPermissionState] across compositions.
 *
 * @param permission the permission to check.
 * @return a [MutableSavedPermissionState]
 */
@ExperimentalPermissionsApi
@Composable
internal fun rememberSavedMutablePermissionState(
    permission: String,
): MutableSavedPermissionState {

    val context = LocalContext.current

    val accompanistPermissionState = rememberPermissionState(permission = permission)

    val permissionState = remember(accompanistPermissionState.status) {
        MutableSavedPermissionState(
            permissionState = accompanistPermissionState,
            activity = context.findActivity()
        )
    }

    return permissionState
}

/**
 * A mutable state object that control and observe if the [SavedPermissionStatus] for the requested [permission] has changed.
 *
 * @param permissionState the permission to check.
 * @param activity is required to check if it is necessary to show a rationale for the requested [permission] to the user.
 */
@ExperimentalPermissionsApi
@Stable
internal class MutableSavedPermissionState(
    private val permissionState: PermissionState,
    private val activity: Activity
) : SavedPermissionState {

    override val permission: String = permissionState.permission

    override var status: SavedPermissionStatus by mutableStateOf(getPermissionStatus())

    override fun requestPermission() {
        permissionState.launchPermissionRequest()
    }

    private fun shouldShowRational(): Boolean = permissionState.status.shouldShowRationale
        .also { shouldShowRational ->
            if (shouldShowRational) {
                setRationalViewed(true)
            }
        }

    private fun hasRationalViewed(): Boolean = activity
        .getPreferences(Context.MODE_PRIVATE)
        .getBoolean(permissionState.permission, false)

    private fun setRationalViewed(hasViewed: Boolean) = activity
        .getPreferences(Context.MODE_PRIVATE)
        .edit()
        .putBoolean(permissionState.permission, hasViewed)
        .apply()

    private fun getPermissionStatus(): SavedPermissionStatus = when (permissionState.status) {
        Granted -> {
            setRationalViewed(false)
            SavedPermissionStatus.Granted
        }
        is Denied -> {
            if (shouldShowRational() || hasRationalViewed().not()) {
                SavedPermissionStatus.ShowRationale
            } else {
                SavedPermissionStatus.Denied
            }
        }
    }
}
