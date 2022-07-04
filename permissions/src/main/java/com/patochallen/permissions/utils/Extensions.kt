package com.patochallen.permissions.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 * Find the closest Activity in a given Context.
 */
internal fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("Permissions should be called in the context of an Activity")
}

/**
 * Check self permission for the given permission.
 *
 * @param permission the permission to check.
 * @return true if the permission is granted, otherwise returns false.
 */
internal fun Context.checkPermission(permission: String): Boolean =
    ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

/**
 * Check if the app should show a rational to user..
 *
 * @param permission the permission to check.
 * @return true if the rational should be showed, otherwise returns false.
 */
internal fun Activity.shouldShowRationale(permission: String): Boolean =
    ActivityCompat.shouldShowRequestPermissionRationale(this, permission)

/**
 * Launch's an intent that open the app settings to allow the user to grant the permission manually.
 */
internal fun Context.launchSettingsIntent() {
    startActivity(
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", packageName, null)
        )
    )
}
