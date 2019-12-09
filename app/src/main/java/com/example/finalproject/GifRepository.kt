package com.example.finalproject

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GifRepository(context: Context) {
    private val giphyService: GiphyApi = GiphyApi.create(context)

    fun getRandomGif(tag: String) : LiveData<Gif> {
        val data = MutableLiveData<Gif>()

        giphyService.getRandomGif(tag,"R", API_KEY).enqueue(object: Callback<GifResponse> {
            override fun onResponse(call : Call<GifResponse>, response: Response<GifResponse>) {
                data.value = response.body()?.data
            }

            override fun onFailure(call: Call<GifResponse>, t: Throwable){
                //nothing yet
            }
        })

        return data
    }

    companion object{
        private const val API_KEY = "YdwxPNt3JQbgS8rKBDs3hawt4BhmmwHW"
    }



}