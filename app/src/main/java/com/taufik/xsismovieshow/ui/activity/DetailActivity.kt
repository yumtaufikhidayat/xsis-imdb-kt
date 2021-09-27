package com.taufik.xsismovieshow.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.taufik.xsismovieshow.R
import com.taufik.xsismovieshow.data.model.MovieItem
import com.taufik.xsismovieshow.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var intentData: MovieItem

    companion object {
        const val TAG = "DETAIL_ACTIVITY"
        const val EXTRA_DETAIL = "com.taufik.xsismovieshow.ui.activity.EXTRA_DETAIL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setParcelable()

        setInitActionBar()

        setDetailData()
    }

    private fun setParcelable() {
        intentData = intent.extras?.getParcelable<MovieItem>(EXTRA_DETAIL) as MovieItem
        Log.e(TAG, "setParcelable: $intentData")
    }

    private fun setInitActionBar() {
        supportActionBar?.apply {
            elevation = 0F
            title = intentData.title
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setDetailData() {
        binding.apply {
            imgBackdrop.loadImage(intentData.image)
            imgPoster.loadImage(intentData.image)
            tvTitle.text = intentData.title
            tvReleaseDate.text = intentData.year
            tvCrews.text = intentData.crew
            tvRatings.text = String.format(intentData.imDbRating + " (IMDb)")
            tvRanks.text = String.format(intentData.rank + " (IMDb)")
        }
    }

    private fun ImageView.loadImage(url: String) {
        Glide.with(this.context)
            .load(url)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}