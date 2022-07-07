package com.patochallen.permissions.camera

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.PermissionDefaults
import com.patochallen.permissions.common.PermissionStrings
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.model.ExperimentalPermissionApi

@ExperimentalPermissionApi
@Composable
fun RequestCameraPermission(
    strings: PermissionStrings = PermissionDefaults.cameraStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.CAMERA,
    strings = strings,
    iconId = R.drawable.camera,
    content = content
)
