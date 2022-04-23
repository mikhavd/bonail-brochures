package com.example.brochures.recycler

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brochures.R

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
private class BrochureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var imageView: ImageView = itemView.findViewById(R.id.icon_view)
    private var name: TextView = itemView.findViewById(R.id.brochure_name)

    fun bindView(brochureItem: BrochureItem) {
        Log.d("brochures", "BrochureViewHolder.bindView(brochureItem: $brochureItem)")
        imageView.setImageDrawable(brochureItem.image)
        name.text = brochureItem.retailerName
    }
}