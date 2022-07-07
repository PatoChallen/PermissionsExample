package com.patochallen.permissions.model

import androidx.compose.runtime.Stable
import com.google.accompanist.permissions.ExperimentalPermissionsApi

/**
 * Model of the status of a permission.
 * It can be [Granted], [ShowRationale] or [Denied].
 * If denied, it should show a rationale to the user.
 */
@ExperimentalPermissionsApi
@Stable
sealed interface SavedPermissionStatus {
    /**
     * Indicates that the permission was granted by the user
     */
    object Granted : SavedPermissionStatus

    /**
     * Indicates that the permission was already denied by the user once, and should be show a rationale
     */
    object ShowRationale : SavedPermissionStatus

    /**
     * Indicates that the user has already denied the permission, and must grant it manually from the settings
     */
    object Denied : SavedPermissionStatus
}
