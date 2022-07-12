package com.patochallen.permissions.location

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
fun RequestLocationPermission(
    strings: PermissionStrings = locationStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.ACCESS_COARSE_LOCATION,
    strings = strings,
    iconId = R.drawable.ic_location,
    content = content
)

/**
 * Creates a [PermissionStrings] that represents the default strings used of the [RequestLocationPermission].
 *
 * @param permissionTitle The text to be displayed in the title of the [RequestLocationPermission].
 * @param permissionRationalMessage The text to be displayed in the rationale message of the [RequestLocationPermission].
 * @param permissionDeniedMessage The text to be displayed in the denied message of the [RequestLocationPermission].
 * @param continueButtonText The text to be displayed in continue button of the [RequestLocationPermission].
 * @param goToSettingsButtonText The text to be displayed in go to settings button of the [RequestLocationPermission].
 */
@Composable
fun locationStrings(
    permissionTitle: String = stringResource(string.location_title),
    permissionRationalMessage: String = stringResource(string.location_rational_message),
    permissionDeniedMessage: String = stringResource(string.location_permission_denied_message),
    continueButtonText: String = stringResource(string.continue_button_text),
    goToSettingsButtonText: String = stringResource(string.open_settings_button_text)
): PermissionStrings = DefaultPermissionsStrings(
    permissionTitle = permissionTitle,
    permissionRationalMessage = permissionRationalMessage,
    permissionDeniedMessage = permissionDeniedMessage,
    continueButtonText = continueButtonText,
    goToSettingsButtonText = goToSettingsButtonText
)
