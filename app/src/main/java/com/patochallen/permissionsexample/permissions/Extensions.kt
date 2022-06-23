package com.patochallen.permissionsexample.permissions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

internal fun Context.goToSettings() {
    startActivity(
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", packageName, null)
        )
    )
}
