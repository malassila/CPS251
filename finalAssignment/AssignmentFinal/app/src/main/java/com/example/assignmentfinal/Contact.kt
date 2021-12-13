package com.example.assignmentfinal

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "ContactName")
    var ContactName: String? = null
    var ContactNumber: String? = null

    constructor(){}

    constructor(ContactName: String,ContactNumber: String){
        this.ContactName = ContactName
        this.ContactNumber = ContactNumber
    }
}