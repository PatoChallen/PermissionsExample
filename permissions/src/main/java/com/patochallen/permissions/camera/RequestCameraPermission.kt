package com.patochallen.permissions.camera

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.common.RequestPermissionDefaults
import com.patochallen.permissions.common.RequestPermissionStrings
import com.patochallen.permissions.model.ExperimentalApi

@Composable
@ExperimentalApi
fun RequestCameraPermission(
    strings: RequestPermissionStrings = RequestPermissionDefaults.cameraStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.CAMERA,
    strings = strings,
    iconId = R.drawable.camera,
    content = content
)
