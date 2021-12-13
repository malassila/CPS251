package com.example.assignmentfinal

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults =  MutableLiveData<List<Contact>>()
    private var ContactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactDatabase? = ContactDatabase.getDatabase(application)
        ContactDao = db?.ContactDao()
        allContacts = ContactDao?.getAllContacts()
    }

    fun insertContact(newContact: Contact){
        coroutineScope.launch(Dispatchers.IO){
            asyncInsert(newContact)
        }
    }

    private suspend fun asyncInsert(Contact: Contact){
        ContactDao?.insertContact(Contact)
    }

    fun deleteContact(id:Int){
        coroutineScope.launch(Dispatchers.IO){
            asyincDelete(id)
        }
    }

    private suspend fun asyincDelete(id: Int){
        ContactDao?.deleteContact(id)
    }

    fun ascending(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncAsc().await()
        }
    }

    private suspend fun asyncAsc(): Deferred<List<Contact>?> = coroutineScope.async(Dispatchers.IO){
        return@async ContactDao?.getAllContactsAsc()
    }

    fun descending(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncDesc().await()
        }
    }

    private suspend fun asyncDesc(): Deferred<List<Contact>?> = coroutineScope.async(Dispatchers.IO){
        return@async ContactDao?.getAllContactsDesc()
    }

    fun findContact(name: String){
        coroutineScope.async(Dispatchers.Main){
            searchResults.value = asyncFind(name).await()
        }
    }

    private suspend fun  asyncFind(name: String): Deferred<List<Contact>?> = coroutineScope.async(
        Dispatchers.IO){
        return@async ContactDao?.findContact(name)
    }

}