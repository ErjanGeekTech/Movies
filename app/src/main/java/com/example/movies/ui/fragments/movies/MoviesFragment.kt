package com.example.movies.ui.fragments.movies

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movies.R
import com.example.movies.base.BaseFragment
import com.example.movies.databinding.FragmentMoviesBinding
import com.example.movies.ui.adapters.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : BaseFragment<FragmentMoviesBinding, MovieViewModel>(R.layout.fragment_movies) {
    override val binding by viewBinding(FragmentMoviesBinding::bind)
    override val viewModel: MovieViewModel by viewModels()
    private val adapter = MovieAdapter()

    override fun setupViews() {
        viewModel.getMovies()
        binding.rv.adapter = adapter
    }

    override fun setupRequests() {
        viewModel.moviesList.observe(viewLifecycleOwner, {
            adapter.addList(it)
        })
    }
}