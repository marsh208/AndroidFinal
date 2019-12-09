package com.example.finalproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.finalproject.GifRepository

class GifViewModel(application: Application) : AndroidViewModel(application){
    private val repository = GifRepository(application.applicationContext)

    fun getRandomGif(tag: String) = repository.getRandomGif(tag)


}