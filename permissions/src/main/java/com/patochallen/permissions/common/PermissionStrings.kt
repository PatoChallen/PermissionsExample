package com.patochallen.permissions.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.res.stringResource
import com.patochallen.permissions.R.string
import com.patochallen.permissions.camera.RequestCameraPermission
import com.patochallen.permissions.location.RequestLocationPermission
import com.patochallen.permissions.microphone.RequestMicrophonePermission

/**
 * Represents the strings used in all permission requests
 *
 * See [PermissionDefaults.cameraStrings] for the default strings used in a [RequestCameraPermission].
 * See [PermissionDefaults.microphoneStrings] for the default strings used in a [RequestMicrophonePermission].
 * See [PermissionDefaults.locationStrings] for the default strings used in a [RequestLocationPermission].
 */
@Stable
interface PermissionStrings {
    /**
     * Represents the text to be displayed in the title.
     */
    @Composable
    fun permissionTitle(): State<String>

    /**
     * Represents the text to be displayed in the rational message.
     */
    @Composable
    fun permissionRationalMessage(): State<String>

    /**
     * Represents the text to be displayed in the denied message.
     */
    @Composable
    fun permissionDeniedMessage(): State<String>

    /**
     * Represents the text to be displayed in the continue button.
     */
    @Composable
    fun continueButtonText(): State<String>

    /**
     * Represents the text to be displayed in the go to strings button.
     */
    @Composable
    fun goToSettingsButtonText(): State<String>
}

/**
 * Contains the default strings used in all permission requests
 */
object PermissionDefaults {
    /**
     * Creates a [PermissionStrings] that represents the default strings used of the [RequestCameraPermission].
     *
     * @param permissionTitle The text to be displayed in the title of the [RequestCameraPermission].
     * @param permissionRationalMessage The text to be displayed in the rational message of the [RequestCameraPermission].
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

    /**
     * Creates a [PermissionStrings] that represents the default strings used of the [RequestMicrophonePermission].
     *
     * @param permissionTitle The text to be displayed in the title of the [RequestMicrophonePermission].
     * @param permissionRationalMessage The text to be displayed in the rational message of the [RequestMicrophonePermission].
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

    /**
     * Creates a [PermissionStrings] that represents the default strings used of the [RequestLocationPermission].
     *
     * @param permissionTitle The text to be displayed in the title of the [RequestLocationPermission].
     * @param permissionRationalMessage The text to be displayed in the rational message of the [RequestLocationPermission].
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
}

/**
 * Default [PermissionStrings] implementation.
 */
@Immutable
class DefaultPermissionsStrings(
    private val permissionTitle: String,
    private val permissionRationalMessage: String,
    private val permissionDeniedMessage: String,
    private val continueButtonText: String,
    private val goToSettingsButtonText: String,
) : PermissionStrings {

    @Composable
    override fun permissionTitle(): State<String> {
        return rememberUpdatedState(permissionTitle)
    }

    @Composable
    override fun permissionRationalMessage(): State<String> {
        return rememberUpdatedState(permissionRationalMessage)
    }

    @Composable
    override fun permissionDeniedMessage(): State<String> {
        return rememberUpdatedState(permissionDeniedMessage)
    }

    @Composable
    override fun continueButtonText(): State<String> {
        return rememberUpdatedState(continueButtonText)
    }

    @Composable
    override fun goToSettingsButtonText(): State<String> {
        return rememberUpdatedState(goToSettingsButtonText)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as DefaultPermissionsStrings

        if (permissionTitle != other.permissionTitle) return false
        if (permissionRationalMessage != other.permissionRationalMessage) return false
        if (permissionDeniedMessage != other.permissionDeniedMessage) return false
        if (continueButtonText != other.continueButtonText) return false
        if (goToSettingsButtonText != other.goToSettingsButtonText) return false

        return true
    }

    override fun hashCode(): Int {
        var result = permissionTitle.hashCode()
        result = 31 * result + permissionRationalMessage.hashCode()
        result = 31 * result + permissionDeniedMessage.hashCode()
        result = 31 * result + goToSettingsButtonText.hashCode()
        result = 31 * result + goToSettingsButtonText.hashCode()
        return result
    }
}
