package com.example.assignmentfinal

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insertContact(Contact: Contact)

    @Query("SELECT * FROM Contacts WHERE ContactName LIKE '%'|| :name || '%'")
    fun findContact(name: String): List<Contact>

    @Query("DELETE FROM Contacts WHERE contactId = :id")
    fun deleteContact(id: Int)

    @Query("SELECT * FROM Contacts")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM Contacts ORDER BY ContactName ASC")
    fun getAllContactsAsc(): List<Contact>

    @Query("SELECT * FROM Contacts ORDER BY ContactName DESC")
    fun getAllContactsDesc(): List<Contact>
}