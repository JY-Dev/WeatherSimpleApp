package com.example.weathersimpleapp.bind

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide

@BindingAdapter("setImage")
fun setImage(imageView: ImageView,imageUrl : String){
    Glide.with(imageView.context)
        .load(imageUrl)
        .into(imageView)
}

@BindingAdapter("setIsRefreshing")
fun setSwipe(swipeRefreshLayout: SwipeRefreshLayout , isRefreshing : Boolean){
    swipeRefreshLayout.isRefreshing = isRefreshing
}