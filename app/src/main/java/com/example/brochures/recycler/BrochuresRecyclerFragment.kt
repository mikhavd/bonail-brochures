package com.example.brochures.recycler

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.brochures.R

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class BrochuresRecyclerFragment : Fragment() {

    private lateinit var brochuresRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.recycler_fragment, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() { //todo
        val brochuresList = arrayListOf(BrochureItem("name", null, "retailer_name"))
        brochuresRecyclerView.adapter = BrochuresAdapter(brochuresList)
    }

    private fun initView(view: View) {
        brochuresRecyclerView = view.findViewById(R.id.recycler)
    }
}