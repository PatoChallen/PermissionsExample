package com.patochallen.permissions.location

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.common.RequestPermissionDefaults
import com.patochallen.permissions.common.RequestPermissionStrings
import com.patochallen.permissions.model.ExperimentalApi

@Composable
@ExperimentalApi
fun RequestLocationPermission(
    strings: RequestPermissionStrings = RequestPermissionDefaults.locationStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.ACCESS_COARSE_LOCATION,
    strings = strings,
    iconId = R.drawable.location,
    content = content
)
