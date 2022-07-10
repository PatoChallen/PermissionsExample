package com.patochallen.permissions.storage

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.PermissionDefaults
import com.patochallen.permissions.common.PermissionStrings
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.model.ExperimentalPermissionApi

@ExperimentalPermissionApi
@Composable
fun RequestStoragePermission(
    strings: PermissionStrings = PermissionDefaults.storageStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.READ_EXTERNAL_STORAGE,
    strings = strings,
    iconId = R.drawable.ic_storage,
    content = content
)
