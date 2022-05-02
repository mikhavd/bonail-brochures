package com.example.brochures.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.brochures.databinding.BrochureGridItemBinding
import com.example.brochures.network.robopojo.ContentItem

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class BrochuresGridAdapter : ListAdapter<ContentItem,
    BrochuresGridAdapter.BrochureViewHolder>(DiffCallback) {

    class BrochureViewHolder(private val binding: BrochureGridItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contentItem: ContentItem) {
            binding.contentItem = contentItem
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrochureViewHolder {
        return BrochureViewHolder(BrochureGridItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BrochureViewHolder, position: Int) {
        val contentItem = getItem(position)
        holder.bind(contentItem)
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of
     * [MarsPhoto] has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<ContentItem>() {
        override fun areItemsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
            return oldItem.brochureImage == newItem.brochureImage
        }
    }
}