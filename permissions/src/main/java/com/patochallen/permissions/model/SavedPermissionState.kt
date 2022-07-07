package com.patochallen.permissions.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.google.accompanist.permissions.ExperimentalPermissionsApi

/**
 * remember the [SavedPermissionState] across compositions.
 *
 * @param permission the permission to check.
 * @return a [SavedPermissionState]
 */
@ExperimentalPermissionsApi
@Composable
fun rememberSavedPermissionState(
    permission: String
): SavedPermissionState = rememberSavedMutablePermissionState(permission)

/**
 * A state object that control and observe if the [SavedPermissionStatus] for the requested [permission] has changed.
 */
@ExperimentalPermissionsApi
@Stable
interface SavedPermissionState {

    /**
     * The permission to check.
     */
    val permission: String

    /**
     * The status of the [permission]
     */
    val status: SavedPermissionStatus

    /**
     * Request the [permission] to the user.
     *
     * This opens a system dialog asking the user whether the permission should be granted or not.
     */
    fun requestPermission()
}
