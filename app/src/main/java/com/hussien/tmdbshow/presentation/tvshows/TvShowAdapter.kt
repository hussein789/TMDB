package com.hussien.tmdbshow.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hussien.tmdbshow.data.model.tvshow.TvShow
import com.hussien.tmdbshow.databinding.MovieItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {


    private var tvShows = mutableListOf<TvShow>()

    fun setData(list:List<TvShow>){
        tvShows.clear()
        tvShows.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater,parent,false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    inner class TvShowViewHolder(private val binding:MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow){
            binding.movieTitle.text = tvShow.name
            binding.movieDesc.text = tvShow.overview
            val imageUrl = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
            Glide.with(binding.movieImage.context)
                .load(imageUrl)
                .into(binding.movieImage)
        }
    }

}