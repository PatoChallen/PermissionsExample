package com.patochallen.sample.screens.contacts

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.Contacts
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import com.patochallen.sample.screens.contacts.model.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ContactListViewModel @Inject constructor(
    private val resolver: ContentResolver
) : ViewModel() {

    val contactList = flow {
        emit(getContacts())
    }.map { list ->
        list.groupBy { it.name.first().uppercase() }
    }

    @SuppressLint("Range")
    private fun getContacts(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        resolver.query(
            /* uri = */ Contacts.CONTENT_URI,
            /* projection = */ null,
            /* selection = */ null,
            /* selectionArgs = */ null,
            /* sortOrder = */ Contacts.DISPLAY_NAME + " ASC"
        )?.run {
            while (count > 0 && moveToNext()) {
                val id = getString(getColumnIndex(Contacts._ID)).orEmpty()
                val name = getString(getColumnIndex(Contacts.DISPLAY_NAME)).orEmpty()
                val photoUri = getString(getColumnIndex(Contacts.PHOTO_URI)).orEmpty().toUri()
                val starred = getInt(getColumnIndex(Contacts.STARRED)) == 1
                val hasPhone = getInt(getColumnIndex(Contacts.HAS_PHONE_NUMBER)) == 1
                val hasEmail = resolver.query(
                    /* uri = */ Email.CONTENT_URI,
                    /* projection = */ null,
                    /* selection = */ Email.CONTACT_ID + " = ?",
                    /* selectionArgs = */ arrayOf(id),
                    /* sortOrder = */ null
                )?.run {
                    val hasEmail = count > 0
                    close()
                    hasEmail
                } ?: false
                if (name.isNotEmpty()) {
                    contacts.add(
                        Contact(
                            id = id,
                            name = name,
                            starred = starred,
                            photoUri = photoUri,
                            hasPhone = hasPhone,
                            hasEmail = hasEmail
                        )
                    )
                }
            }
            close()
        }
        return contacts
    }
}
