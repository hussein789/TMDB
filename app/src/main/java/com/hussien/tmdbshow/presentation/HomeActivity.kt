package com.hussien.tmdbshow.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hussien.tmdbshow.R
import com.hussien.tmdbshow.databinding.ActivityHomeBinding
import com.hussien.tmdbshow.presentation.artists.ArtistsActivity
import com.hussien.tmdbshow.presentation.movies.MoviesActivity
import com.hussien.tmdbshow.presentation.tvshows.TvShowsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        initClickListeners()
    }

    private fun initClickListeners() {
        binding.movieBtn.setOnClickListener {
            launchMovieScreen()
        }
        binding.artistsBtn.setOnClickListener {
            launchArtistScreen()
        }
        binding.tvshowBtn.setOnClickListener {
            launchTvShowScreen()
        }
    }

    private fun launchTvShowScreen() {
        val intent = Intent(this, TvShowsActivity::class.java)
        startActivity(intent)
    }

    private fun launchArtistScreen() {
        val intent = Intent(this, ArtistsActivity::class.java)
        startActivity(intent)
    }

    private fun launchMovieScreen() {
        val intent = Intent(this, MoviesActivity::class.java)
        startActivity(intent)
    }
}