package com.mane.android.home_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mane.android.home_ui.compose.DetailsScreen
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var viewModel: DetailsViewModel
    private val args: DetailsFragmentArgs by navArgs()

    private val navigateBack = {
        this.findNavController().popBackStack()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AndroidSupportInjection.inject(this)
        viewModel.findBreedData(args.breedID)

        return ComposeView(requireContext()).apply {

            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
            )
            setContent {
                MaterialTheme {
                    DetailsScreen(viewModel, navigateBack)
                }
            }
        }
    }

    private fun findBreedData(id: Int) {
        viewModel.findBreedData(id)
    }
}