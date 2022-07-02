package com.patochallen.permissionsexample

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
import com.patochallen.permissions.camera.RequestCameraPermissions
import com.patochallen.permissions.model.ExperimentalApi
import com.patochallen.permissionsexample.ui.theme.PermissionsExampleTheme

@OptIn(ExperimentalApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PermissionsExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RequestCameraPermissions {
                        Box(contentAlignment = Alignment.Center) {
                            Text(text = "CAMERA PERMISSION GRANTED")
                        }
                    }
                }
            }
        }
    }
}
