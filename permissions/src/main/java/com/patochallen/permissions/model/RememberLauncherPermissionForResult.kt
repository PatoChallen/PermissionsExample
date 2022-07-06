package com.patochallen.permissions.model

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.compose.runtime.Composable

/**
 * Register a request to start an activity for result, designated to [request a permission][Activity.requestPermissions].
 *
 * @param onResult the callback to be called on the main thread when activity result is available.
 * @return the [launcher][rememberLauncherForActivityResult] that can be used to start the activity.
 */
@Composable
internal fun rememberLauncherPermissionForResult(
    onResult: (Boolean) -> Unit = {}
) = rememberLauncherForActivityResult(
    contract = RequestPermission(),
    onResult = onResult
)
