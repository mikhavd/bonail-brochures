package com.example.brochures.brochuresfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brochures.R

/**
 * Adapter for brochures list display
 *
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class BrochuresAdapter(private val items: List<BrochureItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.brochre_item_card,
            parent,
            false)
        return BrochureViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? BrochureViewHolder)?.bindView(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * ViewHolder for Brochure item
     * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
     */
    private class BrochureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //todo private var imageView: ImageView = itemView.findViewById(R.id.icon_view)
        private var name: TextView = itemView.findViewById(R.id.brochure_name)
        private val retailerName: TextView = itemView.findViewById(R.id.retailer_name)

        fun bindView(brochureItem: BrochureItem) {
            //todo brochureItem.image?.let { imageView.setImageDrawable(it) }
            name.text = brochureItem.name
            retailerName.text = brochureItem.additionalDescription
        }
    }
}