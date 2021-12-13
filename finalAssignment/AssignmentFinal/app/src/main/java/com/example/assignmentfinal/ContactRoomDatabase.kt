package com.example.assignmentfinal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Contact::class)], version = 1)
abstract class ContactDatabase: RoomDatabase() {

    abstract fun ContactDao(): ContactDao

    companion object{
        private var INSTANCE: ContactDatabase? = null

        internal fun getDatabase(context: Context): ContactDatabase? {
            if (INSTANCE == null){
                synchronized(ContactDatabase::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder<ContactDatabase>(context.applicationContext,ContactDatabase::class.java,"Contact_Database").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}