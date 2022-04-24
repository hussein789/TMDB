package com.hussien.tmdbshow.presentation.movies

import com.BaseUnitTest
import com.google.common.truth.Truth.assertThat
import com.hussien.tmdbshow.data.model.movie.Movie
import com.hussien.tmdbshow.domain.usecase.GetMoviesUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateMoviesUseCase
import com.nhaarman.mockitokotlin2.whenever
import com.vezeeta.patients.app.utils.captureValues
import com.vezeeta.patients.app.utils.getValueForTest
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class MoviesViewModelTest : BaseUnitTest(){

    lateinit var viewModel: MoviesViewModel
    lateinit var getMoviesUseCase:GetMoviesUseCase
    lateinit var updateMoviesUseCase:UpdateMoviesUseCase

    var activeList = listOf(Movie(1,"overview1","posterpath1","release date 1","title1"),
        Movie(2,"overview2","posterpath2","release date 2","title2"))
    var updateList = listOf(Movie(3,"overview3","posterpath1","release date 13","title13"),
        Movie(4,"overview42","posterpath42","release date 42","title42"))

    @Before
    fun setup() = runBlocking{
        getMoviesUseCase = mock(GetMoviesUseCase::class.java)
        updateMoviesUseCase = mock(UpdateMoviesUseCase::class.java)

        whenever(getMoviesUseCase.excute()).thenReturn(activeList)
        whenever(updateMoviesUseCase.excute()).thenReturn(updateList)

        viewModel = MoviesViewModel(getMoviesUseCase,updateMoviesUseCase)
    }

    @Test
    fun getMovies_showLoading() = runBlockingTest{
        viewModel.loadingState.captureValues {
            assertThat(values.first()).isEqualTo(false)
            viewModel.getMovies()
            assertThat(values[1]).isEqualTo(true)
            assertThat(values.last()).isEqualTo(false)
        }
    }

    @Test
    fun getMovies_emitActiveMovies(){
        viewModel.getMovies()

        val result = viewModel.moviesState.getValueForTest()

        assertThat(result).isEqualTo(activeList)
    }

    @Test
    fun updateMovies_emitUpdatedMovies(){
        viewModel.updateMovies()

        val result = viewModel.moviesState.getValueForTest()

        assertThat(result).isEqualTo(updateList)
    }

    @Test
    fun updateMovies_showLoading(){
        viewModel.loadingState.captureValues {
            assertThat(values[0]).isEqualTo(false)
            viewModel.updateMovies()
            assertThat(values[1]).isEqualTo(true)
            assertThat(values.last()).isEqualTo(false)
        }
    }

    fun mockSuccessCase(){
        viewModel = MoviesViewModel(getMoviesUseCase,updateMoviesUseCase)
    }
}