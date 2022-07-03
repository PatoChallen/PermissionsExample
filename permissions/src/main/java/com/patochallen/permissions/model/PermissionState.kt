package com.patochallen.permissions.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

/**
 * remember the [PermissionState] across compositions.
 *
 * @param permission the permission to check.
 * @return a [PermissionState]
 */
@ExperimentalApi
@Composable
fun rememberPermissionState(
    permission: String
): PermissionState = rememberMutablePermissionState(permission)

/**
 * A state object that control and observe if the [PermissionStatus]
 * for the requested [permission] has changed.
 */
@ExperimentalApi
@Stable
interface PermissionState {

    /**
     * The permission to check.
     */
    val permission: String

    /**
     * The status of the [permission]
     */
    val status: PermissionStatus

    /**
     * Launch the [permission] request to the user.
     *
     * This launch a system dialog that asks the user if the permission must be granted or not.
     */
    fun launchPermissionRequest()
}
