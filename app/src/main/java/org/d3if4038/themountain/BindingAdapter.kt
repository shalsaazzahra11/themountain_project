package org.d3if4038.themountain

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.d3if4038.themountain.listview.ListviewAdapter
import org.d3if4038.themountain.listview.TheMountainApiStatus
import org.d3if4038.themountain.network.TheMountainProperty

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri()
            .buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<TheMountainProperty>?){
    val adapter = recyclerView.adapter as ListviewAdapter
    adapter.submitList(data)
}
@BindingAdapter("theMountainApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: TheMountainApiStatus?){
    when (status) {
        TheMountainApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource((R.drawable.ic_connection_error))
        }
        TheMountainApiStatus.DONE ->{
            statusImageView.visibility = View.GONE
        }
    }
}