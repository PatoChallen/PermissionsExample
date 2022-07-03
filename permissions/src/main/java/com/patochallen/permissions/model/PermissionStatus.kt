package com.patochallen.permissions.model

import androidx.compose.runtime.Stable

/**
 * Model of the status of a permission.
 * It can be [Granted], [ShowRational] or [Denied].
 * If denied, it should show a rationale to the user.
 */
@ExperimentalApi
@Stable
sealed interface PermissionStatus {
    /**
     * Indicates that the permission was granted by the user
     */
    object Granted : PermissionStatus

    /**
     * Indicates that the permission was already denied by the user once,
     * and should be show a rational
     */
    object ShowRational : PermissionStatus

    /**
     * Indicates that the user has already denied the permission,
     * and must grant it manually from the settings
     */
    object Denied : PermissionStatus
}
