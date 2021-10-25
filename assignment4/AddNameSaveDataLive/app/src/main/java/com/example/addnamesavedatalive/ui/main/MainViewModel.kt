package com.example.addnamesavedatalive.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var names: MutableLiveData<String> = MutableLiveData()
    //private var names = "No names to display!"

    fun setName(value: String){

        //this.names = value;
        names.setValue(value)

    }
    fun getResult(): MutableLiveData<String>{
        return names
    }



}