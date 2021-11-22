package com.example.recyclerview

import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    companion object {


        val saveTitle = arrayListOf<String>()
        val saveDetails = arrayListOf<String>()
        val saveImage = arrayListOf<Int>()

        fun randomTitle(i: Int): String {

            for (detail in Data.titles){
                saveTitle.add(Data.titles.random())
            }
            return saveTitle[i]
        }

        fun randomDetail(i: Int): String {

            for (detail in Data.details) {
                saveDetails.add(Data.details.random())
            }

            return saveDetails[i]
        }
            fun randomImage(i: Int): Int {

            for (image in Data.images) {
                saveImage.add(Data.images.random())
            }

        return saveImage[i]


        }


    }




}




