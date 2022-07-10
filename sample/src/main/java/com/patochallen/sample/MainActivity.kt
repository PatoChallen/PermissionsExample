package com.patochallen.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.patochallen.permissions.camera.RequestCameraPermission
import com.patochallen.permissions.location.RequestLocationPermission
import com.patochallen.permissions.microphone.RequestMicrophonePermission
import com.patochallen.permissions.model.ExperimentalPermissionApi

@OptIn(ExperimentalPermissionApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RequestLocationPermission {
                        RequestMicrophonePermission {
                            RequestCameraPermission {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(text = "PERMISSIONS GRANTED")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
