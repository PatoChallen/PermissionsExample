package com.patochallen.permissions.custom

import androidx.compose.runtime.Composable
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.model.ExperimentalPermissionApi

@ExperimentalPermissionApi
@Composable
fun RequestCustomPermission(
    permission: String,
    showRationalContent: @Composable ((onClick: () -> Unit) -> Unit),
    permissionDeniedContent: @Composable ((onClick: () -> Unit) -> Unit),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission,
    showRationalContent = showRationalContent,
    permissionDeniedContent = permissionDeniedContent,
    content = content
)
