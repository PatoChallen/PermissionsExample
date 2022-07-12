package com.patochallen.permissions.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import com.patochallen.permissions.camera.RequestCameraPermission
import com.patochallen.permissions.camera.cameraStrings
import com.patochallen.permissions.location.RequestLocationPermission
import com.patochallen.permissions.location.locationStrings
import com.patochallen.permissions.microphone.RequestMicrophonePermission
import com.patochallen.permissions.microphone.microphoneStrings

/**
 * Represents the strings used in all permission requests
 *
 * See [cameraStrings] for the default strings used in a [RequestCameraPermission].
 * See [microphoneStrings] for the default strings used in a [RequestMicrophonePermission].
 * See [locationStrings] for the default strings used in a [RequestLocationPermission].
 */
@Stable
interface PermissionStrings {
    /**
     * Represents the text to be displayed in the title.
     */
    @Composable
    fun permissionTitle(): State<String>

    /**
     * Represents the text to be displayed in the rationale message.
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
