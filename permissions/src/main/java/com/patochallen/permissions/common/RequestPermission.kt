package com.patochallen.permissions.common

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.patochallen.permissions.model.ExperimentalApi
import com.patochallen.permissions.model.PermissionState
import com.patochallen.permissions.model.PermissionStatus.Denied
import com.patochallen.permissions.model.PermissionStatus.Granted
import com.patochallen.permissions.model.PermissionStatus.ShowRational
import com.patochallen.permissions.model.rememberPermissionState
import com.patochallen.permissions.utils.launchSettingsIntent

@Composable
@ExperimentalApi
fun RequestPermission(
    permission: String,
    strings: PermissionStrings,
    @DrawableRes iconId: Int,
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission,
    showRationalContent = { onClick ->
        ShowRationalContent(
            permissionTitle = strings.permissionTitle().value,
            rationalMessage = strings.permissionRationalMessage().value,
            buttonText = strings.continueButtonText().value,
            iconId = iconId,
            onClick = onClick
        )
    },
    permissionDeniedContent = { onClick ->
        PermissionDeniedContent(
            permissionTitle = strings.permissionTitle().value,
            goToSettingsMessage = strings.permissionDeniedMessage().value,
            buttonText = strings.goToSettingsButtonText().value,
            iconId = iconId,
            onClick = onClick
        )
    },
    content = content
)

@Composable
@ExperimentalApi
internal fun RequestPermission(
    permission: String,
    showRationalContent: @Composable ((onClick: () -> Unit) -> Unit),
    permissionDeniedContent: @Composable ((onClick: () -> Unit) -> Unit),
    content: @Composable (() -> Unit)
) {
    val context = LocalContext.current
    val permissionState: PermissionState = rememberPermissionState(permission)

    when (permissionState.status) {
        Granted -> {
            content()
        }
        ShowRational -> {
            showRationalContent {
                permissionState.requestPermission()
            }
        }
        is Denied -> {
            permissionDeniedContent {
                context.launchSettingsIntent()
            }
        }
    }
}
