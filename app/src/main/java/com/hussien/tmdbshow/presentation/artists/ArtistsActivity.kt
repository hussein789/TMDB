package com.hussien.tmdbshow.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hussien.tmdbshow.R
import com.hussien.tmdbshow.databinding.ActivityArtistsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityArtistsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artists)
    }
}