package com.patochallen.permissions.model

import androidx.compose.runtime.Stable
import com.patochallen.permissions.model.PermissionStatus.Denied
import com.patochallen.permissions.model.PermissionStatus.Granted
import com.patochallen.permissions.model.PermissionStatus.ShowRational

/**
 * Model of the status of a permission.
 * It can be [Granted], [ShowRational] or [Denied].
 * If denied, it should show a rationale to the user.
 */
@ExperimentalApi
@Stable
sealed interface PermissionStatus {
    object Granted : PermissionStatus
    object ShowRational : PermissionStatus
    object Denied : PermissionStatus
}
