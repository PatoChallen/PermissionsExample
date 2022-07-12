package com.patochallen.sample.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract.Contacts
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Suppress("MagicNumber")
fun getRandomColor(): Color = with(Random) {
    val red = nextInt(256)
    val green = nextInt(256)
    val blue = nextInt(256)
    Color(red, green, blue)
}

fun Context.launchContactIntent(contactId: String) {
    startActivity(
        Intent(Intent.ACTION_VIEW).apply {
            data = Uri.withAppendedPath(
                Contacts.CONTENT_URI,
                contactId
            )
        }
    )
}
