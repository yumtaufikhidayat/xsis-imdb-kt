package com.taufik.xsismovieshow.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taufik.xsismovieshow.data.model.MovieItem
import com.taufik.xsismovieshow.databinding.ItemExploreMoviesBinding


class ExploreMoviesAdapter : RecyclerView.Adapter<ExploreMoviesAdapter.MovieViewHolder>(){

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

        val oddPos = position % 2

        val rank = listMovies[position].rank.toInt()
        Log.e(TAG, "onBindViewHolder: $rank")

        if (oddPos == 1) {
            
        }

//        if (oddPos == 1) {
//            for (i in oddPos until listMovies.size) {
//                holder.bind(listMovies[position])
//            }
//        } else {
//            holder.bind(listMovies[position])
//        }
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding: ItemExploreMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: MovieItem) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(movieItem.image)
                    .into(imgPoster)

                tvTitle.text = movieItem.title
                tvYear.text = movieItem.year
                tvRating.text = movieItem.imDbRating
            }
        }
    }

    companion object {
        const val TAG = "EXPLORE_MOVIES"
    }
}