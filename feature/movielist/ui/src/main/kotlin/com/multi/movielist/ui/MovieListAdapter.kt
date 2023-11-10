package com.multi.movielist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.multi.movielist.domain.model.Movie
import com.multi.movielist.ui.databinding.ItemMovieBinding
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class MovieListAdapter @Inject constructor() :
    RecyclerView.Adapter<MovieListAdapter.MovieItemHolder>() {

    private val movieList = ArrayList<Movie>()

    fun update(updatedList: List<Movie>) {

        val diffResult = DiffUtil.calculateDiff(
            MovieListDiffUtil(
                movieList,
                updatedList
            )
        )

        movieList.clear()
        movieList.addAll(updatedList)
        diffResult.dispatchUpdatesTo(this)
    }

    class MovieItemHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieItemHolder(binding)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieItemHolder, position: Int) {
        holder.binding.movie = movieList[position]
        holder.binding.executePendingBindings()
    }
}