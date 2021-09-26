package com.taufik.xsismovieshow.data.model


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("items")
    val movieItems: List<MovieItem>,
    @SerializedName("errorMessage")
    val errorMessage: String
)