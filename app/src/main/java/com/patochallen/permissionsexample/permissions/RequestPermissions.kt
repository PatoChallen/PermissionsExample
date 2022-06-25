@file:OptIn(ExperimentalPermissionsApi::class)

package com.patochallen.permissionsexample.permissions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState

@Composable
fun RequestPermissions(
    permission: String,
    permissionState: PermissionState = rememberPermissionState(permission),
    permissionNotGrantedContent: @Composable (() -> Unit),
    showRationalContent: @Composable (() -> Unit),
    permissionDeniedContent: @Composable (() -> Unit),
    content: @Composable (() -> Unit)
) {
    val context = LocalContext.current

    when {
        permissionState.hasPermission -> {
            content()
        }
        permissionState.permissionRequested && permissionState.shouldShowRationale -> {
            PermissionContentWrapper(
                buttonText = "Request permission",
                content = showRationalContent
            ) {
                permissionState.launchPermissionRequest()
            }
        }
        permissionState.hasPermissionDenied() -> {
            PermissionContentWrapper(
                buttonText = "Open settings",
                content = permissionDeniedContent
            ) {
                context.launchSettingsIntent()
            }
        }
        else -> {
            PermissionContentWrapper(
                buttonText = "Request permission",
                content = permissionNotGrantedContent
            ) {
                permissionState.launchPermissionRequest()
            }
        }
    }
}

@Composable
private fun PermissionContentWrapper(
    buttonText: String,
    content: @Composable (() -> Unit),
    onClick: () -> Unit
) {
    Column(modifier = Modifier.padding(32.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            shape = CircleShape,
            contentPadding = PaddingValues(15.dp)
        ) {
            Text(
                text = buttonText.uppercase(),
                style = MaterialTheme.typography.button,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

private fun PermissionState.hasPermissionDenied() =
    permissionRequested && shouldShowRationale.not()

private fun Context.launchSettingsIntent() {
    startActivity(
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", packageName, null)
        )
    )
}
