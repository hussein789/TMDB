package com.hussien.tmdbshow.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hussien.tmdbshow.R
import com.hussien.tmdbshow.data.model.movie.Movie
import com.hussien.tmdbshow.databinding.ActivityMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {

    @Inject lateinit var factory:MoviesViewModelFactory

    private lateinit var binding:ActivityMoviesBinding
    private lateinit var viewModel:MoviesViewModel

    private var adapter = MoviesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movies)
        viewModel = ViewModelProvider(this,factory)[MoviesViewModel::class.java]
        initRecyclerView()
        observeViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val actionId = item.itemId
        return when(actionId){
            R.id.refresh_action ->{
                viewModel.updateMovies()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun observeViewModel() {
        viewModel.moviesState.observe(this){ movies ->
            movies?.let { updateMoviesList(it) }
        }

        viewModel.loadingState.observe(this){ loading ->
            loading?.let { handleLoading(it) }
        }
    }

    private fun handleLoading(show: Boolean) {
        binding.progress.visibility = if(show) View.VISIBLE else View.GONE
    }

    private fun updateMoviesList(movies: List<Movie>) {
        adapter.setData(movies)
        adapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        binding.moviesRv.layoutManager = LinearLayoutManager(this)
        binding.moviesRv.adapter = adapter
    }


}