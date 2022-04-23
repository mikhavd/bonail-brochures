package com.example.brochures.brochuresfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.brochures.R

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
        val view = inflater.inflate(R.layout.brochures_recycler_fragment, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() { //todo
        val brochuresList = model.getBrochures().value
        brochuresRecyclerView.adapter = brochuresList?.let(::BrochuresAdapter)
    }

    private fun initView(view: View) {
        brochuresRecyclerView = view.findViewById(R.id.recycler)
    }
}