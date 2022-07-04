package com.patochallen.permissions.microphone

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.common.RequestPermissionDefaults
import com.patochallen.permissions.common.RequestPermissionStrings
import com.patochallen.permissions.model.ExperimentalApi

@Composable
@ExperimentalApi
fun RequestMicrophonePermission(
    strings: RequestPermissionStrings = RequestPermissionDefaults.microphoneStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.RECORD_AUDIO,
    strings = strings,
    iconId = R.drawable.microphone,
    content = content
)
