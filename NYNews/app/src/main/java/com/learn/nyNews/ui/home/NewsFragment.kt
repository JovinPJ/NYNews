package com.learn.nyNews.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.nyNews.databinding.FragmentNewsBinding
import com.learn.nyNews.ui.base.BaseFragment
import com.learn.nyNews.ui.home.placeholder.PlaceholderContent

class NewsFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        //binding.viewModel = viewModel
        val adapter = NewsAdapter()
        adapter.submitList(PlaceholderContent.ITEMS)
        binding.adapter = adapter
        return binding.root
    }
}