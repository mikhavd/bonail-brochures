package com.example.brochures.brochuresfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.brochures.R
import com.example.brochures.databinding.FragmentOverviewBinding
import com.example.brochures.network.robopojo.ContentItem
import com.example.brochures.recycler.BrochuresAdapter
import com.example.brochures.recycler.DisplayableBrochureItem

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class BrochuresRecyclerFragment : Fragment() {

    private val model: BrochuresViewModel by viewModels()
    private lateinit var brochuresRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        //todo val binding = GridViewItemBinding.inflate(inflater)
        val binding = FragmentOverviewBinding.inflate(inflater)
        val view = inflater.inflate(R.layout.brochures_recycler_fragment, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        model.brochures.observe(viewLifecycleOwner) { this.onBrochuresUpdated(it) }
    }

    private fun onBrochuresUpdated(brochuresList: List<ContentItem>) {
        brochuresList.mapNotNull { it.retailer?.name?.let(::DisplayableBrochureItem) }.let { list ->
            brochuresRecyclerView.adapter = BrochuresAdapter(list)
        }
    }

    private fun initView(view: View) {
        brochuresRecyclerView = view.findViewById(R.id.recycler)
    }
}