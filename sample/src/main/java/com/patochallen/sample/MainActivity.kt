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
import com.patochallen.sample.camera.RequestCameraPermissions
import com.patochallen.sample.microphone.RequestMicrophonePermissions
import com.patochallen.sample.ui.theme.PermissionsSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PermissionsSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RequestMicrophonePermissions {
                        RequestCameraPermissions {
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
