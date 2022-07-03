package com.patochallen.permissions.microphone

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.PermissionDeniedContent
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.common.ShowRationalContent
import com.patochallen.permissions.model.ExperimentalApi

@Composable
@ExperimentalApi
fun RequestMicrophonePermission(
    content: @Composable (() -> Unit)
) {
    RequestPermission(
        permission = permission.RECORD_AUDIO,
        showRationalContent = { onClick ->
            ShowRationalContent(
                permissionTitle = "Enable Microphone",
                rationalMessage = "Please provide access to\nyour microphone, " +
                    "which is required\nfor use the App",
                buttonText = "Continue",
                iconId = R.drawable.microphone,
                onClick = onClick
            )
        },
        permissionDeniedContent = { onClick ->
            PermissionDeniedContent(
                permissionTitle = "Enable Microphone",
                goToSettingsMessage = "The permission has been denied\ntwo times, " +
                    "Please open settings\nand grant permissions manually",
                buttonText = "Open Settings",
                onClick = onClick
            )
        },
        content = content
    )
}
