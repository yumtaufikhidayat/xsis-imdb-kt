package com.taufik.xsismovieshow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taufik.xsismovieshow.data.model.MovieItem
import com.taufik.xsismovieshow.databinding.ItemMoviesBinding

class Top10MoviesAdapter() : RecyclerView.Adapter<Top10MoviesAdapter.MovieViewHolder>() {

    private val listMovies = ArrayList<MovieItem>()

    fun setMovies(listMovies: List<MovieItem>) {
        this.listMovies.clear()
        this.listMovies.addAll(listMovies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int {
        if (listMovies.size > 20) {
            return 10
        }
        return listMovies.size
    }

    inner class MovieViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: MovieItem) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(movieItem.image)
                    .into(imgPoster)

                tvRating.text = movieItem.imDbRating
                tvTitle.text = movieItem.title
                tvYear.text = String.format("(" + movieItem.year + ")")
            }
        }
    }
}