package com.example.movies.ui.fragments.movies.detail

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import coil.transform.CircleCropTransformation
import com.example.movies.R
import com.example.movies.base.BaseFragment
import com.example.movies.data.network.NetworkConnectionLiveData
import com.example.movies.databinding.FragmentDetailBinding
import com.example.movies.ui.fragments.movies.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding, MovieViewModel>(R.layout.fragment_detail) {

    override val binding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: MovieViewModel by activityViewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun initialize() {
        NetworkConnectionLiveData(context ?: return)
            .observe(viewLifecycleOwner, { isConnected ->
                if (isConnected) {
                    viewModel.fetchMovie(args.id)
                } else {
                    findNavController().navigate(R.id.action_detailFragment_to_isConnectedFragment)
                }
            })
    }

    override fun setupRequests() {
        viewModel.movie.observe(viewLifecycleOwner, {
            binding.apply {
                detailName.text = it.name
                rating.text = it.rating.average.toString()
                detailImg.load(it.image.original) {
                    crossfade(true)
                    transformations(
                        CircleCropTransformation()
                    )
                }
                detailStatus.text = it.status
                detailGengers.text = it.genres.toString()
                desc.text = it.summary.replace("[^A-Za-z0-9 ]".toRegex(), "")
                detailLanguage.text = it.language
                detailEnded.text = it.ended
                detailType.text = it.type
            }
        })
    }
}