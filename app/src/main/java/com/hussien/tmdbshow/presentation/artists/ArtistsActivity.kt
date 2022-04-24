package com.hussien.tmdbshow.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hussien.tmdbshow.R
import com.hussien.tmdbshow.data.model.artist.Artist
import com.hussien.tmdbshow.databinding.ActivityArtistsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityArtistsBinding
    private lateinit var viewModel:ArtistsViewModel

    @Inject lateinit var factory:ArtistsViewModelFactory

    private var artistAdapter = ArtistsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artists)
        viewModel = ViewModelProvider(this,factory)[ArtistsViewModel::class.java]
        initViews()
        observeViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if(itemId == R.id.refresh_action){
            viewModel.updateArtists()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun observeViewModel() {
        viewModel.loadingState.observe(this){ show->
            show?.let { handleLoading(it) }
        }

        viewModel.artistsListState.observe(this){artists ->
            artists?.let { updateList(it) }
        }
    }

    private fun updateList(list: List<Artist>) {
        artistAdapter.setData(list)
        artistAdapter.notifyDataSetChanged()
    }

    private fun handleLoading(show: Boolean) {
        binding.progress.isVisible = show
    }

    private fun initViews() {
        binding.artistsRv.apply {
            layoutManager = LinearLayoutManager(this@ArtistsActivity)
            adapter = artistAdapter
        }
    }
}