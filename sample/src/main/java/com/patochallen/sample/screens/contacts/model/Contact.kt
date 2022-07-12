package com.patochallen.sample.screens.contacts.model

import android.net.Uri
import androidx.compose.ui.graphics.Color
import com.patochallen.sample.utils.getRandomColor

data class Contact(
    val id: String,
    val name: String,
    val starred: Boolean,
    val photoUri: Uri,
    val hasPhone: Boolean,
    val hasEmail: Boolean,
    val color: Color = getRandomColor()
)
