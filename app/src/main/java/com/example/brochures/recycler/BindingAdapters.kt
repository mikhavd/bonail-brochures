package com.example.brochures.recycler
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.brochures.R
import com.example.brochures.brochuresfragment.BrochuresApiStatus
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


/**
 * This binding adapter displays the [BrochuresApiStatus] of the network request in an image view.  When
 * the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
 */
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: BrochuresApiStatus?) {
    when (status) {
        BrochuresApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        BrochuresApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        BrochuresApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

class BindingAdapters {
}