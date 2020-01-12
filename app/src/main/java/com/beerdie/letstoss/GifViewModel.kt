package com.beerdie.letstoss

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class GifViewModel(application: Application) : AndroidViewModel(application){
    private val repository = GifRepository(application.applicationContext)

    fun getRandomGif(tag: String) = repository.getRandomGif(tag)


}