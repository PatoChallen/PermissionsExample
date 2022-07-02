package com.patochallen.permissions.permissions

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
import com.patochallen.permissions.model.ExperimentalApi
import com.patochallen.permissions.model.PermissionState
import com.patochallen.permissions.model.PermissionStatus.Denied
import com.patochallen.permissions.model.PermissionStatus.Granted
import com.patochallen.permissions.model.PermissionStatus.ShowRational
import com.patochallen.permissions.model.rememberPermissionState
import com.patochallen.permissions.utils.launchSettingsIntent

@Composable
@ExperimentalApi
fun RequestPermissions(
    permission: String,
    permissionState: PermissionState = rememberPermissionState(permission),
    showRationalContent: @Composable (() -> Unit),
    permissionDeniedContent: @Composable (() -> Unit),
    content: @Composable (() -> Unit)
) {
    val context = LocalContext.current

    when (permissionState.status) {
        Granted -> {
            content()
        }
        ShowRational -> {
            PermissionContentWrapper(
                buttonText = "Continue",
                content = showRationalContent
            ) {
                permissionState.launchPermissionRequest()
            }
        }
        is Denied -> {
            PermissionContentWrapper(
                buttonText = "Open settings",
                content = permissionDeniedContent
            ) {
                context.launchSettingsIntent()
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
    Column {
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp),
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
