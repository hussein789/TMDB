package com.hussien.tmdbshow.presentation.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hussien.tmdbshow.R
import com.hussien.tmdbshow.data.model.tvshow.TvShow
import com.hussien.tmdbshow.databinding.ActivityTvShowsBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notify
import javax.inject.Inject

@AndroidEntryPoint
class TvShowsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTvShowsBinding
    private lateinit var viewModel:TvShowsViewModel

    @Inject lateinit var factory: TvShowsViewModelFactory

    private var adapter = TvShowAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_shows)
        viewModel = ViewModelProvider(this,factory)[TvShowsViewModel::class.java]
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
            viewModel.updateTvShows()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun observeViewModel() {
        viewModel.loadingState.observe(this){show ->
            show?.let { handleLoading(it) }
        }

        viewModel.tvShowsState.observe(this){tvShowList ->
            tvShowList?.let { handleTvShows(it) }
        }
    }

    private fun handleTvShows(tvShowList: List<TvShow>) {
        adapter.setData(tvShowList)
        adapter.notifyDataSetChanged()
    }

    private fun handleLoading(show: Boolean) {
        binding.progress.isVisible = show
    }

    private fun initViews() {
        initRecycler()
    }

    private fun initRecycler() {
        binding.tvShowRv.layoutManager = LinearLayoutManager(this)
        binding.tvShowRv.adapter = adapter
    }
}