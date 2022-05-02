package com.example.brochures.recycler
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.brochures.R
import com.example.brochures.network.robopojo.ContentItem

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
        // Load the image in the background using Coil.
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ContentItem>?) {
    val adapter = recyclerView.adapter as BrochuresGridAdapter
    adapter.submitList(data)
}

class BindingAdapters {
}