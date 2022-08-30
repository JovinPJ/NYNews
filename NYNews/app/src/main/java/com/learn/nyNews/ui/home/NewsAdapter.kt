package com.learn.nyNews.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learn.nyNews.databinding.NewsItemBinding
import com.learn.nyNews.domain.model.Article


class NewsAdapter(private val newsItemClickListener: NewsItemClickListener) :
    ListAdapter<Article, NewsAdapter.NewsViewHolder>(Companion) {

    class NewsViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article):
                Boolean = oldItem === newItem

        override fun areContentsTheSame(oldItem: Article, newItem: Article):
                Boolean = oldItem.title == newItem.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentArticle = getItem(position)
        holder.binding.article = currentArticle
        holder.binding.newsItemClick = newsItemClickListener
        holder.binding.executePendingBindings()
    }

}