package com.patochallen.permissions.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patochallen.permissions.R.drawable

@Composable
internal fun PermissionDeniedContent(
    permissionTitle: String,
    goToSettingsMessage: String,
    buttonText: String,
    onClick: () -> Unit
) {
    PermissionContentWrapper(
        buttonText = buttonText,
        onClick = onClick
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .shadow(15.dp, CircleShape, false)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = drawable.location),
                    contentDescription = "Permission Icon",
                    modifier = Modifier
                        .fillMaxSize()
                )
                Image(
                    painter = painterResource(id = drawable.ic_warning),
                    contentDescription = "Warning Icon",
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.TopStart)
                        .offset(x = 25.unaryMinus().dp, y = 25.unaryMinus().dp)
                        .shadow(5.dp, CircleShape, false)
                        .background(MaterialTheme.colors.error, CircleShape)
                        .padding(15.dp)
                        .padding(bottom = 5.dp),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onError)
                )
            }
            Spacer(modifier = Modifier.height(70.dp))
            Text(
                text = permissionTitle,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = goToSettingsMessage,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .border(2.dp, MaterialTheme.colors.error, RoundedCornerShape(16.dp))
                    .background(
                        MaterialTheme.colors.error.copy(alpha = 0.1f),
                        RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                lineHeight = 25.sp,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}
