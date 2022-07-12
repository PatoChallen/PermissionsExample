package com.patochallen.sample.screens.contacts

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
fun RequestContactsPermission(
    strings: PermissionStrings = contactStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.READ_CONTACTS,
    strings = strings,
    iconId = R.drawable.ic_contacts,
    content = content
)

/**
 * Creates a [PermissionStrings] that represents the default strings used of the [RequestContactsPermission].
 *
 * @param permissionTitle The text to be displayed in the title of the [RequestContactsPermission].
 * @param permissionRationalMessage The text to be displayed in the rationale message of the [RequestContactsPermission].
 * @param permissionDeniedMessage The text to be displayed in the denied message of the [RequestContactsPermission].
 * @param continueButtonText The text to be displayed in continue button of the [RequestContactsPermission].
 * @param goToSettingsButtonText The text to be displayed in go to settings button of the [RequestContactsPermission].
 */
@Composable
fun contactStrings(
    permissionTitle: String = stringResource(string.contacts_title),
    permissionRationalMessage: String = stringResource(string.contacts_rational_message),
    permissionDeniedMessage: String = stringResource(string.contacts_permission_denied_message),
    continueButtonText: String = stringResource(string.continue_button_text),
    goToSettingsButtonText: String = stringResource(string.open_settings_button_text)
): PermissionStrings = DefaultPermissionsStrings(
    permissionTitle = permissionTitle,
    permissionRationalMessage = permissionRationalMessage,
    permissionDeniedMessage = permissionDeniedMessage,
    continueButtonText = continueButtonText,
    goToSettingsButtonText = goToSettingsButtonText
)
