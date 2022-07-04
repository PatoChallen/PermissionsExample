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
 * Represents the strings used in all request permission screens
 *
 * See [RequestPermissionDefaults.cameraStrings] for the default strings used in a [RequestCameraPermission].
 * See [RequestPermissionDefaults.microphoneStrings] for the default strings used in a [RequestMicrophonePermission].
 * See [RequestPermissionDefaults.locationStrings] for the default strings used in a [RequestLocationPermission].
 */
@Stable
interface RequestPermissionStrings {
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
 * Contains the default strings used by all request permission screens
 */
object RequestPermissionDefaults {
    /**
     * Creates a [RequestPermissionStrings] that represents the default strings used in [RequestCameraPermission].
     *
     * @param permissionTitle The text to be displayed in the title in [RequestCameraPermission].
     * @param permissionRationalMessage The text to be displayed in the rational message in [RequestCameraPermission].
     * @param permissionDeniedMessage The text to be displayed in the denied message in [RequestCameraPermission].
     * @param continueButtonText The text to be displayed in continue button in [RequestCameraPermission].
     * @param goToSettingsButtonText The text to be displayed in go to settings button in [RequestCameraPermission].
     */
    @Composable
    fun cameraStrings(
        permissionTitle: String = stringResource(string.camera_title),
        permissionRationalMessage: String = stringResource(string.camera_rational_message),
        permissionDeniedMessage: String = stringResource(string.camera_permission_denied_message),
        continueButtonText: String = stringResource(string.continue_button_text),
        goToSettingsButtonText: String = stringResource(string.open_settings_button_text)
    ): RequestPermissionStrings = DefaultPermissionsStrings(
        permissionTitle = permissionTitle,
        permissionRationalMessage = permissionRationalMessage,
        permissionDeniedMessage = permissionDeniedMessage,
        continueButtonText = continueButtonText,
        goToSettingsButtonText = goToSettingsButtonText
    )

    /**
     * Creates a [RequestPermissionStrings] that represents the default strings used in [RequestMicrophonePermission].
     *
     * @param permissionTitle The text to be displayed in the title in [RequestMicrophonePermission].
     * @param permissionRationalMessage The text to be displayed in the rational message in [RequestMicrophonePermission].
     * @param permissionDeniedMessage The text to be displayed in the denied message in [RequestMicrophonePermission].
     * @param continueButtonText The text to be displayed in continue button in [RequestMicrophonePermission].
     * @param goToSettingsButtonText The text to be displayed in go to settings button in [RequestMicrophonePermission].
     */
    @Composable
    fun microphoneStrings(
        permissionTitle: String = stringResource(string.microphone_title),
        permissionRationalMessage: String = stringResource(string.microphone_rational_message),
        permissionDeniedMessage: String = stringResource(string.microphone_permission_denied_message),
        continueButtonText: String = stringResource(string.continue_button_text),
        goToSettingsButtonText: String = stringResource(string.open_settings_button_text)
    ): RequestPermissionStrings = DefaultPermissionsStrings(
        permissionTitle = permissionTitle,
        permissionRationalMessage = permissionRationalMessage,
        permissionDeniedMessage = permissionDeniedMessage,
        continueButtonText = continueButtonText,
        goToSettingsButtonText = goToSettingsButtonText
    )

    /**
     * Creates a [RequestPermissionStrings] that represents the default strings used in [RequestLocationPermission].
     *
     * @param permissionTitle The text to be displayed in the title in [RequestLocationPermission].
     * @param permissionRationalMessage The text to be displayed in the rational message in [RequestLocationPermission].
     * @param permissionDeniedMessage The text to be displayed in the denied message in [RequestLocationPermission].
     * @param continueButtonText The text to be displayed in continue button in [RequestLocationPermission].
     * @param goToSettingsButtonText The text to be displayed in go to settings button in [RequestLocationPermission].
     */
    @Composable
    fun locationStrings(
        permissionTitle: String = stringResource(string.location_title),
        permissionRationalMessage: String = stringResource(string.location_rational_message),
        permissionDeniedMessage: String = stringResource(string.location_permission_denied_message),
        continueButtonText: String = stringResource(string.continue_button_text),
        goToSettingsButtonText: String = stringResource(string.open_settings_button_text)
    ): RequestPermissionStrings = DefaultPermissionsStrings(
        permissionTitle = permissionTitle,
        permissionRationalMessage = permissionRationalMessage,
        permissionDeniedMessage = permissionDeniedMessage,
        continueButtonText = continueButtonText,
        goToSettingsButtonText = goToSettingsButtonText
    )
}

/**
 * Default [RequestPermissionStrings] implementation.
 */
@Immutable
class DefaultPermissionsStrings(
    private val permissionTitle: String,
    private val permissionRationalMessage: String,
    private val permissionDeniedMessage: String,
    private val continueButtonText: String,
    private val goToSettingsButtonText: String,
) : RequestPermissionStrings {

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
