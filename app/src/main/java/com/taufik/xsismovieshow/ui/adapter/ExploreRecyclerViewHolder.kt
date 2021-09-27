package com.taufik.xsismovieshow.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.taufik.xsismovieshow.databinding.ItemExploreMoviesBinding
import com.taufik.xsismovieshow.databinding.ItemMoviesLeftBinding
import com.taufik.xsismovieshow.databinding.ItemMoviesRightBinding

sealed class ExploreRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class TitleViewHolder(private val binding: ItemExploreMoviesBinding) :
        ExploreRecyclerViewHolder(binding) {
        fun bind(title: ExploreRecyclerViewItem.Title) {
            binding.tvExploreMovies.text = title.title
        }
    }

    class MoviesLeftViewHolder(private val binding: ItemMoviesLeftBinding) :
        ExploreRecyclerViewHolder(binding) {
        fun bind(movie: ExploreRecyclerViewItem.MoviesLeft) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(movie.image)
                    .into(imgPoster)

                tvTitle.text = movie.title
                tvReleaseDate.text = movie.year
                tvRating.text = movie.imDbRating
            }
        }
    }

    class MoviesRightViewHolder(private val binding: ItemMoviesRightBinding) :
        ExploreRecyclerViewHolder(binding) {
        fun bind(movie: ExploreRecyclerViewItem.MoviesRight) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(movie.image)
                    .into(imgPoster)

                tvTitle.text = movie.title
                tvReleaseDate.text = movie.year
                tvRating.text = movie.imDbRating
            }
        }
    }
}