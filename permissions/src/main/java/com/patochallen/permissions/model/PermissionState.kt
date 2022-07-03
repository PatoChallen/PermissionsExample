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
     * Request the [permission] to the user.
     *
     * This opens a system dialog asking the user whether the permission should be granted or not.
     */
    fun requestPermission()
}
