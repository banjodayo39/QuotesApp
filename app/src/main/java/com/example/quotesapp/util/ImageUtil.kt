package com.example.quotesapp.util

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.quotesapp.R

fun loadCircularImage(context: Context, imageView: ImageView, imageUrl: String?, placeHolder: Int) {

    if (imageUrl != null && !imageUrl.isEmpty()) {
        Glide.with(context)
            .load(imageUrl)
            .placeholder(placeHolder)
            .apply(RequestOptions.circleCropTransform())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    } else {
        imageView.setImageResource(placeHolder)
    }

}

// ImageView
fun ImageView.loadImage(imageUrl: String?, @DrawableRes placeholder: Int = R.drawable.ic_launcher_background) {
    if (imageUrl.isNullOrEmpty()) {
        setImageDrawable(ContextCompat.getDrawable(context, placeholder))
    } else {
        Glide.with(context)
            .load(imageUrl)
            .placeholder(placeholder)
            .apply(RequestOptions.circleCropTransform())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    }
}

fun ImageView.setDrawable(@DrawableRes drawable: Int) {
    setImageDrawable(ContextCompat.getDrawable(context, drawable))
}