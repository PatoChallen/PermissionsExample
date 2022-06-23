package com.patochallen.permissionsexample.permissions

import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

@ExperimentalPermissionsApi
@Composable
internal fun RequestPermissions(
    permissionState: PermissionState,
    permissionNotGrantedContent: @Composable (() -> Unit),
    permissionDeniedContent: @Composable (() -> Unit),
    content: @Composable (() -> Unit)
) {
    when {
        permissionState.hasPermission -> {
            content()
        }
        permissionState.hasPermissionDenied() -> {
            permissionDeniedContent()
        }
        else -> {
            permissionNotGrantedContent()
        }
    }
}

@ExperimentalPermissionsApi
private fun PermissionState.hasPermissionDenied() =
    permissionRequested && shouldShowRationale.not()
