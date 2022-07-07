package com.patochallen.permissions.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun ShowRationalContent(
    permissionTitle: String,
    rationalMessage: String,
    buttonText: String,
    @DrawableRes iconId: Int,
    onClick: () -> Unit
) {
    PermissionContentWrapper(
        buttonText = buttonText,
        onClick = onClick
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = "Permission Icon",
                modifier = Modifier
                    .size(250.dp)
                    .shadow(15.dp, CircleShape)
            )
            Spacer(modifier = Modifier.height(70.dp))
            Text(
                text = permissionTitle,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = rationalMessage,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .padding(16.dp),
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                lineHeight = 25.sp
            )
        }
    }
}
