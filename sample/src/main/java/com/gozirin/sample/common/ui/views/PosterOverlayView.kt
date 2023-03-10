package com.gozirin.sample.common.ui.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.gozirin.sample.R
import com.gozirin.sample.common.extensions.sendShareIntent
import com.gozirin.sample.common.models.Poster
import kotlinx.android.synthetic.main.view_poster_overlay.view.*

class PosterOverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var onDeleteClick: (Poster) -> Unit = {}

    init {
        View.inflate(context, R.layout.view_poster_overlay, this)
        setBackgroundColor(Color.TRANSPARENT)
    }

    fun update(poster: Poster) {
        posterOverlayDescriptionText.text = poster.description
        posterOverlayShareButton.setOnClickListener { context.sendShareIntent(poster.url) }
        posterOverlayDeleteButton.setOnClickListener { onDeleteClick(poster) }
    }
}