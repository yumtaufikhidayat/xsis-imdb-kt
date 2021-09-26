package com.taufik.xsismovieshow.data.api

import com.taufik.xsismovieshow.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(UrlEndpoint.TOP_250_MOVIES)
    fun getAllTop250Movies(
        @Query("apiKey") apiKey: String
    ): Call<MovieResponse>
}