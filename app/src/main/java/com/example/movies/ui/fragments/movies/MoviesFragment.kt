package com.example.movies.ui.fragments.movies

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movies.R
import com.example.movies.base.BaseFragment
import com.example.movies.data.network.NetworkConnectionLiveData
import com.example.movies.databinding.FragmentMoviesBinding
import com.example.movies.ui.adapters.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MoviesFragment : BaseFragment<FragmentMoviesBinding, MovieViewModel>(
    R.layout.fragment_movies
) {

    override val binding by viewBinding(FragmentMoviesBinding::bind)
    override val viewModel: MovieViewModel by activityViewModels()

    private val adapter = MovieAdapter(this::openDetailMovie)

    override fun setupViews() {
        binding.rv.adapter = adapter
    }

    override fun setupRequests() {
        NetworkConnectionLiveData(context ?: return)
            .observe(viewLifecycleOwner, { isConnected ->
                if (isConnected) {
                    viewModel.fetchMovies()
                } else {
                    viewModel.getMovies()
                }
            })
    }

    private fun openDetailMovie(id: Int) {
        findNavController().navigate(
            MoviesFragmentDirections.actionMoviesFragmentToDetailFragment(
                id
            )
        )
    }

    override fun setupObserves() {
        viewModel.moviesList.observe(viewLifecycleOwner, {
            adapter.addList(it)
        })
    }
}

