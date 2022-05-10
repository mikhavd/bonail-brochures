package com.example.brochures.brochuresfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.brochures.databinding.FragmentOverviewBinding
import com.example.brochures.main.AppSchedulerProvider
import com.example.brochures.network.BrochuresApi
import com.example.brochures.recycler.BrochuresGridAdapter

/**
 * Fragment for displaying a grid of brochures
 * @author Mikhail Avdeev (avdeev.m92@gmail.com)
 */
class BrochuresGridFragment : Fragment() {

    private val viewModel: BrochuresViewModel by viewModels {
        BrochuresViewModel.BrochuresViewModelFactory(
            BrochuresApi.brochuresApiService,
            AppSchedulerProvider()
        )
    }

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentOverviewBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the photosGrid RecyclerView
        binding.brochuresGrid.adapter = BrochuresGridAdapter()

        return binding.root
    }
}