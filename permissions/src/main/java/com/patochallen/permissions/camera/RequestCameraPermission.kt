package com.patochallen.permissions.camera

import android.Manifest.permission
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.patochallen.permissions.R
import com.patochallen.permissions.R.string
import com.patochallen.permissions.common.DefaultPermissionsStrings
import com.patochallen.permissions.common.PermissionStrings
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.model.ExperimentalPermissionApi

@ExperimentalPermissionApi
@Composable
fun RequestCameraPermission(
    strings: PermissionStrings = cameraStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.CAMERA,
    strings = strings,
    iconId = R.drawable.ic_camera,
    content = content
)

/**
 * Creates a [PermissionStrings] that represents the default strings used of the [RequestCameraPermission].
 *
 * @param permissionTitle The text to be displayed in the title of the [RequestCameraPermission].
 * @param permissionRationalMessage The text to be displayed in the rationale message of the [RequestCameraPermission].
 * @param permissionDeniedMessage The text to be displayed in the denied message of the [RequestCameraPermission].
 * @param continueButtonText The text to be displayed in continue button of the [RequestCameraPermission].
 * @param goToSettingsButtonText The text to be displayed in go to settings button of the [RequestCameraPermission].
 */
@Composable
fun cameraStrings(
    permissionTitle: String = stringResource(string.camera_title),
    permissionRationalMessage: String = stringResource(string.camera_rational_message),
    permissionDeniedMessage: String = stringResource(string.camera_permission_denied_message),
    continueButtonText: String = stringResource(string.continue_button_text),
    goToSettingsButtonText: String = stringResource(string.open_settings_button_text)
): PermissionStrings = DefaultPermissionsStrings(
    permissionTitle = permissionTitle,
    permissionRationalMessage = permissionRationalMessage,
    permissionDeniedMessage = permissionDeniedMessage,
    continueButtonText = continueButtonText,
    goToSettingsButtonText = goToSettingsButtonText
)
