package com.example.movies.ui.fragments.isConnected

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movies.R
import com.example.movies.base.BaseFragment
import com.example.movies.base.BaseViewModel
import com.example.movies.data.network.NetworkConnectionLiveData
import com.example.movies.databinding.FragmentIsConnectedBinding

class IsConnectedFragment : BaseFragment<FragmentIsConnectedBinding, BaseViewModel>(
    R.layout.fragment_is_connected
) {
    override val binding by viewBinding(FragmentIsConnectedBinding::bind)
    override val viewModel: BaseViewModel by viewModels()

    override fun setupObserves() {
        NetworkConnectionLiveData(context ?: return)
            .observe(viewLifecycleOwner, { isConnected ->
                if (isConnected) {
                    findNavController().navigateUp()
                }
            })
    }
}