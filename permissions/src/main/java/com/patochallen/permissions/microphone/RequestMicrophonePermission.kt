package com.patochallen.permissions.microphone

import android.Manifest.permission
import androidx.compose.runtime.Composable
import com.patochallen.permissions.R
import com.patochallen.permissions.common.PermissionDefaults
import com.patochallen.permissions.common.PermissionStrings
import com.patochallen.permissions.common.RequestPermission
import com.patochallen.permissions.model.ExperimentalPermissionApi

@ExperimentalPermissionApi
@Composable
fun RequestMicrophonePermission(
    strings: PermissionStrings = PermissionDefaults.microphoneStrings(),
    content: @Composable (() -> Unit)
) = RequestPermission(
    permission = permission.RECORD_AUDIO,
    strings = strings,
    iconId = R.drawable.ic_microphone,
    content = content
)
