package com.patochallen.permissions.location

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.PermissionDeniedContent
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.common.ShowRationalContent
import com.patochallen.permissions.model.ExperimentalApi

@Composable
@ExperimentalApi
fun RequestLocationPermission(
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.ACCESS_COARSE_LOCATION,
    showRationalContent = { onClick ->
        ShowRationalContent(
            permissionTitle = "Enable Location",
            rationalMessage = "Please provide access to\nyour location, " +
                "which is required\nfor use the App",
            buttonText = "Continue",
            iconId = R.drawable.location,
            onClick = onClick
        )
    },
    permissionDeniedContent = { onClick ->
        PermissionDeniedContent(
            permissionTitle = "Enable Location",
            goToSettingsMessage = "The permission has been denied\ntwo times, " +
                "Please open settings\nand grant permissions manually",
            buttonText = "Open Settings",
            onClick = onClick
        )
    },
    content = content
)
