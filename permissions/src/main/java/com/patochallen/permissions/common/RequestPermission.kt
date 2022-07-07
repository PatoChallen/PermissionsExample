package com.patochallen.permissions.common

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.patochallen.permissions.model.ExperimentalPermissionApi
import com.patochallen.permissions.model.SavedPermissionState
import com.patochallen.permissions.model.SavedPermissionStatus.Denied
import com.patochallen.permissions.model.SavedPermissionStatus.Granted
import com.patochallen.permissions.model.SavedPermissionStatus.ShowRationale
import com.patochallen.permissions.model.rememberSavedPermissionState
import com.patochallen.permissions.utils.launchSettingsIntent

@ExperimentalPermissionApi
@Composable
internal fun RequestPermission(
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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
internal fun RequestPermission(
    permission: String,
    showRationalContent: @Composable ((onClick: () -> Unit) -> Unit),
    permissionDeniedContent: @Composable ((onClick: () -> Unit) -> Unit),
    content: @Composable (() -> Unit)
) {
    val context = LocalContext.current
    val savedPermissionState: SavedPermissionState = rememberSavedPermissionState(permission)

    when (savedPermissionState.status) {
        Granted -> {
            content()
        }
        ShowRationale -> {
            showRationalContent {
                savedPermissionState.requestPermission()
            }
        }
        is Denied -> {
            permissionDeniedContent {
                context.launchSettingsIntent()
            }
        }
    }
}
