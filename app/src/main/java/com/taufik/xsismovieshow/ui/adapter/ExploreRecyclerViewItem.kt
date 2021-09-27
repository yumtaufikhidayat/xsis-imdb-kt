package com.taufik.xsismovieshow.ui.adapter

import com.google.gson.annotations.SerializedName

sealed class ExploreRecyclerViewItem {
    
    class Title(
        val title: String
    ): ExploreRecyclerViewItem()
    
    class MoviesLeft(
        val id: String,
        val rank: String,
        val title: String,
        val fullTitle: String,
        val year: String,
        val image: String,
        val crew: String,
        val imDbRating: String,
        val imDbRatingCount: String
    ): ExploreRecyclerViewItem()

    class MoviesRight(
        val id: String,
        val rank: String,
        val title: String,
        val fullTitle: String,
        val year: String,
        val image: String,
        val crew: String,
        val imDbRating: String,
        val imDbRatingCount: String
    ): ExploreRecyclerViewItem()
}
