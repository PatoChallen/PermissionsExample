package com.patochallen.permissions.location

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.PermissionDefaults
import com.patochallen.permissions.common.PermissionStrings
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.model.ExperimentalPermissionApi

@ExperimentalPermissionApi
@Composable
fun RequestLocationPermission(
    strings: PermissionStrings = PermissionDefaults.locationStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.ACCESS_COARSE_LOCATION,
    strings = strings,
    iconId = R.drawable.location,
    content = content
)
