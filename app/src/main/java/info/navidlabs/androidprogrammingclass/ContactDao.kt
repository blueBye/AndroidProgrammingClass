package info.navidlabs.androidprogrammingclass

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

// contact data access object
@Dao
interface ContactDao {
    @Upsert  // insert and update
    suspend fun upsertContact(contact: Contact)  // suspend for async

    @Delete
    suspend fun deleteContact(contact: Contact)

    // queries
    @Query("SELECT * FROM contact ORDER BY firstName ASC")
    fun getContactsOrderedByFirstName(): Flow<List<Contact>>  // use flow to get notified when change happened

    @Query("SELECT * FROM contact ORDER BY lastName ASC")
    fun getContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY phoneNumber ASC")
    fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>
}
