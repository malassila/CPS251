package com.example.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var names = "No names to display!"

    fun setName(value: String){

        this.names = value;

    }
    fun getResult(): String{
        return names
    }



}