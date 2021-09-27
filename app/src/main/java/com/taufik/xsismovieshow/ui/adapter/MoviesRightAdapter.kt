package com.taufik.xsismovieshow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taufik.xsismovieshow.data.model.MovieItem
import com.taufik.xsismovieshow.databinding.ItemMoviesRightBinding

class MoviesRightAdapter(private val listMovies: List<MovieItem>): RecyclerView.Adapter<MoviesRightAdapter.MoviesRightHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesRightHolder {
        val view = ItemMoviesRightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesRightHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesRightHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MoviesRightHolder(private val binding: ItemMoviesRightBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: MovieItem) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(movieItem.image)
                    .into(imgPoster)

                tvTitle.text = movieItem.title
                tvReleaseDate.text = movieItem.year
                tvRating.text = movieItem.imDbRating
            }
        }
    }
}