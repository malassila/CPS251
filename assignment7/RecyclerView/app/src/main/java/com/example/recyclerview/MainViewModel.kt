package com.example.recyclerview

import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {

    val saveTitle = arrayListOf<String>()
    val saveDetails = arrayListOf<String>()
    val saveImage = arrayListOf<Int>()

        init {
            randomize()
        }

    private fun randomize() {

        for (detail in Data.titles){
            saveTitle.add(Data.titles.random())
        }

        for (detail in Data.details){
            saveDetails.add(Data.details.random())
        }
        for (image in Data.images) {
            saveImage.add(Data.images.random())
        }



    }
}




