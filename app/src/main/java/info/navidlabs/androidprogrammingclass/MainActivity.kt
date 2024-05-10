package info.navidlabs.androidprogrammingclass

import android.annotation.SuppressLint
import android.content.ContentProviderOperation
import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.UserDictionary
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme
import java.util.Locale
import java.util.UUID


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidProgrammingClassTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(onClick = {
                        addContact(applicationContext, "Bob", "123454321")
                        Log.i("Contacts", "inserting contact")
                    }) {
                        Text(text="insert")
                    }

                    Button(onClick = {
                        val contacts = queryContacts(applicationContext)
                        Log.i("Contacts", contacts.toString())
                    }) {
                        Text(text="query")
                    }
                }
            }
        }
    }

    @SuppressLint("Range")
    private fun queryWordData(searchItem: String?) {
        // A "projection" defines the columns that will be returned for each row
        val projections = arrayOf(
            UserDictionary.Words._ID,  // A contract class constant for _ID column name
            UserDictionary.Words.WORD,  // A contract class constant for WORD column name
            UserDictionary.Words.APP_ID,  // A contract class constant for APP_ID column name
            UserDictionary.Words.LOCALE // A contract class constant for LOCALE column name
        )

        // Defines a string to contain the selection clause
        val selectionClause: String?

        // Initializes an array to contain selection arguments
        val selectionArgs = arrayOf("")

        //pre-process the input to check if it is a valid input
        if (searchItem == null) {
            selectionClause = null
            selectionArgs[0] = ""
        } else {
            selectionClause = UserDictionary.Words.WORD + " = ? "
            selectionArgs[0] = searchItem
        }
        contentResolver.query(
            UserDictionary.Words.CONTENT_URI,
            projections,
            selectionClause,
            selectionArgs,
            "ASC"
        ).use { cursor ->
            if (cursor == null) {
                Log.e("UserDict", "no cursor!")
            }
            else if (cursor.count == 0) {
                Log.w("UserDict", "nothing found!")
            }
            else {
                cursor.moveToFirst()
                Log.i("UserDict", "iterating!")
                while (!cursor.isAfterLast) {
                    // retrieve data
                    val ID = cursor.getString(cursor.getColumnIndex(UserDictionary.Words._ID))
                    val word = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD))
                    val appID = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.APP_ID))
                    val locale = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.LOCALE))

                    Log.i("UserDict", "id: $ID, word: $word, appID: $appID, local: $locale")
                    cursor.moveToNext()
                }
            }
        }
    }

    private fun insertWordData(word: String, frequency: String) {
        val contentValues = ContentValues().apply {
            put(UserDictionary.Words.APP_ID, UUID.randomUUID().toString())
            put(UserDictionary.Words.WORD, word)
            put(UserDictionary.Words.LOCALE, Locale.getDefault().toString())
            put(UserDictionary.Words.FREQUENCY, frequency)
        }

        val newUri = contentResolver.insert(
            UserDictionary.Words.CONTENT_URI,
            contentValues
        )

        if (newUri == null) {
            Log.e("UserDict", "Failed to insert word to UserDictionary")
        } else {
            Log.i("UserDict", "Successfully inserted word: $word")
        }
    }

    private fun addContact(
        context: Context,
        name: String,
        phoneNumber: String
    ) {
        val rawContactUri = context.contentResolver.insert(
            ContactsContract.RawContacts.CONTENT_URI,
            ContentValues()
        )

        val contactId = rawContactUri?.lastPathSegment!!.toInt()

        // specify data for each field
        val dataContentValues = ContentValues()
        dataContentValues.put(ContactsContract.Data.RAW_CONTACT_ID, contactId)
        dataContentValues.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, "Bob 123")
        dataContentValues.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phoneNumber)
        dataContentValues.put(
            ContactsContract.CommonDataKinds.Phone.TYPE,
            ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
        )
        dataContentValues.put(
            ContactsContract.Data.MIMETYPE,
            ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE
        )

        // insert data
        context.contentResolver.insert(ContactsContract.Data.CONTENT_URI, dataContentValues)
    }

    @SuppressLint("Range")
    private fun queryContacts(context: Context): List<Contact> {
        val contentResolver = context.contentResolver
        val projection = arrayOf(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME
        )

        val cursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        val contacts = mutableListOf<Contact>()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                contacts.add(Contact(contactId, displayName))
            }
            cursor.close()
        }

        return contacts
    }

    data class Contact(val id: String, val name: String)
}
