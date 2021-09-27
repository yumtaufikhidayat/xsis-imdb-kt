package com.taufik.xsismovieshow.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.xsismovieshow.data.api.UrlEndpoint
import com.taufik.xsismovieshow.data.viewmodel.XsisMovieShowViewModel
import com.taufik.xsismovieshow.databinding.ActivityMainBinding
import com.taufik.xsismovieshow.ui.adapter.ExploreMoviesAdapter
import com.taufik.xsismovieshow.ui.adapter.Top10MoviesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesAdapter: Top10MoviesAdapter
    private lateinit var exploreMoviesAdapter: ExploreMoviesAdapter
    private lateinit var viewModel: XsisMovieShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMoviesData()
    }

    private fun setMoviesData() {

        moviesAdapter = Top10MoviesAdapter()
        exploreMoviesAdapter = ExploreMoviesAdapter(this)

        with(binding.rvTop10Movies) {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = moviesAdapter
        }

        with(binding.rvExploreMovies) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = exploreMoviesAdapter
        }

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[XsisMovieShowViewModel::class.java]
        viewModel.setMovies(UrlEndpoint.API_KEY)
        viewModel.getAllMovies().observe(this, {
            if (it != null) {
                moviesAdapter.setMovies(it)
                exploreMoviesAdapter.setMovies(it)
            }
        })
    }
}