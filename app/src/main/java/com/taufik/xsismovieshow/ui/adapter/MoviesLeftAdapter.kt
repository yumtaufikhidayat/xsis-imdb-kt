package com.taufik.xsismovieshow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taufik.xsismovieshow.data.model.MovieItem
import com.taufik.xsismovieshow.databinding.ItemMoviesLeftBinding

class MoviesLeftAdapter(private val listMovies: List<MovieItem>): RecyclerView.Adapter<MoviesLeftAdapter.MoviesLeftHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesLeftHolder {
        val view = ItemMoviesLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesLeftHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesLeftHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MoviesLeftHolder(private val binding: ItemMoviesLeftBinding) :
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