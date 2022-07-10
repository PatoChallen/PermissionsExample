package com.patochallen.permissions.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Suppress("MagicNumber")
@Composable
internal fun CircleImage(
    @DrawableRes iconId: Int,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = iconId),
        contentDescription = "",
        tint = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
        modifier = modifier
            .background(
                brush = Brush.radialGradient(
                    0f to MaterialTheme.colors.primary.copy(alpha = 0.5f),
                    0.88f to MaterialTheme.colors.primary,
                    0.94f to MaterialTheme.colors.primary.copy(alpha = 0.25f),
                    1f to MaterialTheme.colors.primary
                ),
                shape = CircleShape
            )
            .padding(60.dp)
    )
}
