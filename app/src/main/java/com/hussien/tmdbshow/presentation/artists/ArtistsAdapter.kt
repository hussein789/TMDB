package com.hussien.tmdbshow.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hussien.tmdbshow.data.model.artist.Artist
import com.hussien.tmdbshow.databinding.MovieItemBinding

class ArtistsAdapter : RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder>() {

    private var movieList = mutableListOf<Artist>()

    fun setData(list:List<Artist>){
        movieList.clear()
        movieList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater,parent,false)
        return ArtistsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistsViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class ArtistsViewHolder(private val binding:MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Artist){
            binding.movieTitle.text = artist.name
            binding.movieDesc.text = ""
            val imageUrl = "https://image.tmdb.org/t/p/w500"+artist.profilePath
            Glide.with(binding.movieImage.context)
                .load(imageUrl)
                .into(binding.movieImage)
        }
    }

}