package com.taufik.xsismovieshow.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taufik.xsismovieshow.data.model.MovieItem
import com.taufik.xsismovieshow.databinding.ItemExploreMoviesBinding


class ExploreMoviesAdapter(
    private val context: Context
) : RecyclerView.Adapter<ExploreMoviesAdapter.MovieViewHolder>(){

    private val listMovies = ArrayList<MovieItem>()

    fun setMovies(listMovies: ArrayList<MovieItem>) {
        this.listMovies.clear()
        this.listMovies.addAll(listMovies)
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ItemExploreMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding: ItemExploreMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: MovieItem) {
            binding.apply {
                val rank = movieItem.rank.toInt()
                for (i in rank until listMovies.size) {
                    if (i % 2 == 0) {
                        setMovieRightCategory(rvItemMoviesRight, listMovies)
                    } else {
                        setMovieLeftCategory(rvItemMoviesLeft, listMovies)
                    }
                }
            }
        }
    }

    private fun setMovieLeftCategory(recyclerView: RecyclerView, movieLeft: List<MovieItem>) {
        val horizontalAdapter = MoviesLeftAdapter(movieLeft)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = horizontalAdapter
    }

    private fun setMovieRightCategory(recyclerView: RecyclerView, movieRight: List<MovieItem>) {
        val verticalAdapter = MoviesRightAdapter(movieRight)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = verticalAdapter
    }
}