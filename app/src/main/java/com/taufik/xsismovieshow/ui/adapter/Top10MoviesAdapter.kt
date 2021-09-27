package com.taufik.xsismovieshow.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.taufik.xsismovieshow.R
import com.taufik.xsismovieshow.data.model.MovieItem
import com.taufik.xsismovieshow.databinding.ItemTop10MoviesBinding
import com.taufik.xsismovieshow.ui.activity.DetailActivity

class Top10MoviesAdapter : RecyclerView.Adapter<Top10MoviesAdapter.MovieViewHolder>() {

    private val listMovies = ArrayList<MovieItem>()

    fun setMovies(listMovies: List<MovieItem>) {
        this.listMovies.clear()
        this.listMovies.addAll(listMovies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ItemTop10MoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val pos = listMovies[position]
        holder.bind(pos)
    }

    override fun getItemCount(): Int {
        if (listMovies.size > 20) {
            return 10
        }
        return listMovies.size
    }

    inner class MovieViewHolder(private val binding: ItemTop10MoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: MovieItem) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(movieItem.image)
                    .apply(
                        RequestOptions
                            .placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                            .dontTransform()
                    )
                    .into(imgPoster)

                tvRating.text = movieItem.imDbRating
                tvTitle.text = movieItem.title
                tvYear.text = String.format("(" + movieItem.year + ")")

                cardPoster.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_DETAIL, movieItem)
                    }
                    it.context.startActivity(intent)
                }
            }
        }
    }
}