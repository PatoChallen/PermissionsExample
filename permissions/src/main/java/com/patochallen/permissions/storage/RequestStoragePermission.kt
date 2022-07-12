package com.patochallen.permissions.storage

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
fun RequestStoragePermission(
    strings: PermissionStrings = storageStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.READ_EXTERNAL_STORAGE,
    strings = strings,
    iconId = R.drawable.ic_storage,
    content = content
)

/**
 * Creates a [PermissionStrings] that represents the default strings used of the [RequestStoragePermission].
 *
 * @param permissionTitle The text to be displayed in the title of the [RequestStoragePermission].
 * @param permissionRationalMessage The text to be displayed in the rationale message of the [RequestStoragePermission].
 * @param permissionDeniedMessage The text to be displayed in the denied message of the [RequestStoragePermission].
 * @param continueButtonText The text to be displayed in continue button of the [RequestStoragePermission].
 * @param goToSettingsButtonText The text to be displayed in go to settings button of the [RequestStoragePermission].
 */
@Composable
fun storageStrings(
    permissionTitle: String = stringResource(string.storage_title),
    permissionRationalMessage: String = stringResource(string.storage_rational_message),
    permissionDeniedMessage: String = stringResource(string.storage_permission_denied_message),
    continueButtonText: String = stringResource(string.continue_button_text),
    goToSettingsButtonText: String = stringResource(string.open_settings_button_text)
): PermissionStrings = DefaultPermissionsStrings(
    permissionTitle = permissionTitle,
    permissionRationalMessage = permissionRationalMessage,
    permissionDeniedMessage = permissionDeniedMessage,
    continueButtonText = continueButtonText,
    goToSettingsButtonText = goToSettingsButtonText
)
