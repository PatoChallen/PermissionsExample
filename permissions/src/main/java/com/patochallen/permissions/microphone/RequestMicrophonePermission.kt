package com.patochallen.permissions.microphone

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
fun RequestMicrophonePermission(
    strings: PermissionStrings = microphoneStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.RECORD_AUDIO,
    strings = strings,
    iconId = R.drawable.ic_microphone,
    content = content
)

/**
 * Creates a [PermissionStrings] that represents the default strings used of the [RequestMicrophonePermission].
 *
 * @param permissionTitle The text to be displayed in the title of the [RequestMicrophonePermission].
 * @param permissionRationalMessage The text to be displayed in the rationale message of the [RequestMicrophonePermission].
 * @param permissionDeniedMessage The text to be displayed in the denied message of the [RequestMicrophonePermission].
 * @param continueButtonText The text to be displayed in continue button of the [RequestMicrophonePermission].
 * @param goToSettingsButtonText The text to be displayed in go to settings button of the [RequestMicrophonePermission].
 */
@Composable
fun microphoneStrings(
    permissionTitle: String = stringResource(string.microphone_title),
    permissionRationalMessage: String = stringResource(string.microphone_rational_message),
    permissionDeniedMessage: String = stringResource(string.microphone_permission_denied_message),
    continueButtonText: String = stringResource(string.continue_button_text),
    goToSettingsButtonText: String = stringResource(string.open_settings_button_text)
): PermissionStrings = DefaultPermissionsStrings(
    permissionTitle = permissionTitle,
    permissionRationalMessage = permissionRationalMessage,
    permissionDeniedMessage = permissionDeniedMessage,
    continueButtonText = continueButtonText,
    goToSettingsButtonText = goToSettingsButtonText
)
