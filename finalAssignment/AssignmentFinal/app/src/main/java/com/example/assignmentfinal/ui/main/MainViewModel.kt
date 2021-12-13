package com.example.assignmentfinal.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignmentfinal.Contact
import com.example.assignmentfinal.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : ContactRepository = ContactRepository(application)
    private val contacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    init {
        contacts = repository.allContacts
        searchResults = repository.searchResults
    }

    fun insertContact(Contact: Contact){
        repository.insertContact(Contact)
    }

    fun findContact(name: String){
        repository.findContact(name)
    }

    fun deleteContact(id: Int){
        repository.deleteContact(id)
    }

    fun ascendingOrder(){
        repository.ascending()
    }

    fun descendingOrder(){
        repository.descending()
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>?{
        return contacts
    }
}