package com.patochallen.permissions.camera

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.PermissionDeniedContent
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.common.ShowRationalContent
import com.patochallen.permissions.model.ExperimentalApi

@Composable
@ExperimentalApi
fun RequestCameraPermission(
    content: @Composable (() -> Unit)
) {
    RequestPermission(
        permission = permission.CAMERA,
        showRationalContent = { onClick ->
            ShowRationalContent(
                permissionTitle = "Enable Camera",
                rationalMessage = "Please provide access to\nyour camera, " +
                    "which is required\nfor use the App",
                buttonText = "Continue",
                iconId = R.drawable.camera,
                onClick = onClick
            )
        },
        permissionDeniedContent = { onClick ->
            PermissionDeniedContent(
                permissionTitle = "Enable Camera",
                goToSettingsMessage = "The permission has been denied.\n" +
                    "Please open settings and\ngrant the permission manually.",
                buttonText = "Open Settings",
                onClick = onClick
            )
        },
        content = content
    )
}
