package com.patochallen.permissions.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle.Event.ON_RESUME
import androidx.lifecycle.LifecycleEventObserver

/**
 * Effect that observes the lifecycle and notify when is called with [ON_RESUME] event.
 *
 * @param onResume the callback to be called when the lifecycle event is [ON_RESUME].
 */
@Composable
fun CheckLifecycleResumeEventEffect(
    onResume: () -> Unit
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == ON_RESUME) {
                onResume()
            }
        }
        lifecycle.addObserver(observer)

        onDispose { lifecycle.removeObserver(observer) }
    }
}
