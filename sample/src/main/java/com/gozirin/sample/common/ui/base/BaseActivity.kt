package com.gozirin.sample.common.ui.base

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.gozirin.sample.R
import com.gozirin.sample.common.extensions.getDrawableCompat
import com.gozirin.sample.common.extensions.loadImage
import com.gozirin.sample.common.models.Poster

abstract class BaseActivity : AppCompatActivity() {

    protected fun loadPosterImage(imageView: ImageView, poster: Poster?) {
        loadImage(imageView, poster?.url)
    }

    protected fun loadImage(imageView: ImageView, url: String?) {
        imageView.apply {
            background = getDrawableCompat(R.drawable.shape_placeholder)
            loadImage(url)
        }
    }
}