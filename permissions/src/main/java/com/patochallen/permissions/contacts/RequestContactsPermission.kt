package com.patochallen.permissions.contacts

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.PermissionDefaults
import com.patochallen.permissions.common.PermissionStrings
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.model.ExperimentalPermissionApi

@ExperimentalPermissionApi
@Composable
fun RequestContactsPermission(
    strings: PermissionStrings = PermissionDefaults.contactStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.READ_CONTACTS,
    strings = strings,
    iconId = R.drawable.ic_contacts,
    content = content
)
