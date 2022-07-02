package com.patochallen.permissions.model

import androidx.compose.runtime.Stable

/**
 * Model of the status of a permission. It can be [Granted], [Denied], [ShowRational] or [Unrequested].
 * If denied, the user might need to be presented with a rationale.
 */
@ExperimentalApi
@Stable
sealed interface PermissionStatus {
    object Granted : PermissionStatus
    object Denied : PermissionStatus
    object ShowRational : PermissionStatus
    object Unrequested : PermissionStatus
}
