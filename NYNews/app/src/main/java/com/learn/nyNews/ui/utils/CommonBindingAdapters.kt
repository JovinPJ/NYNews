package com.learn.nyNews.ui.utils

import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.learn.nyNews.R

@BindingAdapter("isVisible")
fun View.showHide(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    setHasFixedSize(true)
    this.adapter = adapter
}

@BindingAdapter(value = ["loadThumbImage"])
fun ImageView.bindThumbImageView(imgUrl: String?) {
    this.load(imgUrl) {
        crossfade(true)
        transformations(CircleCropTransformation())
    }
}

@BindingAdapter(value = ["loadImage"])
fun ImageView.bindImageView(imgUrl: String?) {
    this.load(imgUrl) {
        crossfade(true)
        setBackgroundColor(ContextCompat.getColor(context, R.color.img_bg))
    }
}

@BindingAdapter(value = ["enableLink"])
fun TextView.bindLink(imgUrl: String?) {
    isClickable = true
    val html = "<a href=$imgUrl>Read more</a>"
    movementMethod = LinkMovementMethod.getInstance()
    text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
}