package com.hussien.tmdbshow.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hussien.tmdbshow.data.model.movie.Movie
import com.hussien.tmdbshow.databinding.MovieItemBinding

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    private var movieList = mutableListOf<Movie>()

    fun setData(list:List<Movie>){
        movieList.clear()
        movieList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater,parent,false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MoviesViewHolder(private val binding:MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie:Movie){
            binding.movieTitle.text = movie.title
            binding.movieDesc.text = movie.overview
            val imageUrl = "https://image.tmdb.org/t/p/w500"+movie.posterPath
            Glide.with(binding.movieImage.context)
                .load(imageUrl)
                .into(binding.movieImage)
        }
    }

}