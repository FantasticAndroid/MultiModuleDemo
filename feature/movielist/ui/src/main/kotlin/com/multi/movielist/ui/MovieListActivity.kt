package com.multi.movielist.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.multi.movielist.domain.model.Movie
import com.multi.movielist.ui.databinding.ActivityMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MovieListActivity : AppCompatActivity() {

    private val movieListViewModel by viewModels<MovieListViewModel>()

    private lateinit var binding: ActivityMovieListBinding

    @Inject
    lateinit var movieListAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.movieRv.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = movieListAdapter
        }

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                movieListViewModel.getMovieList("").collect {
                    when (it) {
                        MovieListViewModel.MovieListUIState.Loading -> {}
                        is MovieListViewModel.MovieListUIState.Success -> {
                            showMovieListOnUI(it.movieList)
                        }
                    }
                }
            }
        }
    }

    private fun showMovieListOnUI(movieList: List<Movie>?) {
        movieList?.let {
            movieListAdapter.update(it)
        }
    }
}