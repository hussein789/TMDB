package com.hussien.tmdbshow.presentation.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hussien.tmdbshow.R
import com.hussien.tmdbshow.databinding.ActivityTvShowsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTvShowsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_shows)
    }
}