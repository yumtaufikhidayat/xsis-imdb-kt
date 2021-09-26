package com.taufik.xsismovieshow.data.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taufik.xsismovieshow.data.api.ApiClient
import com.taufik.xsismovieshow.data.model.MovieItem
import com.taufik.xsismovieshow.data.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class XsisMovieShowViewModel : ViewModel(){

    private val listMovies = MutableLiveData<ArrayList<MovieItem>>()

    fun setMovies(apiKey: String) {
        ApiClient.apiInstance
            .getAllTop250Movies(apiKey)
            .enqueue(object : Callback<MovieResponse>{
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        listMovies.postValue(response.body()?.movieItems as ArrayList<MovieItem>)
                        Log.e(TAG, "onResponse: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.localizedMessage}")
                }
            })
    }

    fun getAllMovies(): LiveData<ArrayList<MovieItem>> {
        return listMovies
    }

    companion object {
        const val TAG = "MOVIE_VIEW_MODEL"
    }
}