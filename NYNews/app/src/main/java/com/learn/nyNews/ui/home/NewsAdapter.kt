package com.learn.nyNews.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learn.nyNews.databinding.NewsItemBinding
import com.learn.nyNews.ui.home.placeholder.PlaceholderContent.PlaceholderItem


class NewsAdapter : ListAdapter<PlaceholderItem, NewsAdapter.NewsViewHolder>(Companion) {

    class NewsViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object : DiffUtil.ItemCallback<PlaceholderItem>() {
        override fun areItemsTheSame(oldItem: PlaceholderItem, newItem: PlaceholderItem): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(
            oldItem: PlaceholderItem,
            newItem: PlaceholderItem
        ): Boolean = oldItem.content == newItem.content
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentPlaceHolder = getItem(position)
        holder.binding.placeHolder = currentPlaceHolder
        holder.binding.executePendingBindings()
    }

}