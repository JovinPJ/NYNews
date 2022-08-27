package com.learn.nyNews.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.learn.nyNews.databinding.FragmentNewsBinding
import com.learn.nyNews.ui.base.BaseFragment
import com.learn.nyNews.ui.home.placeholder.PlaceholderContent

class NewsFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        val adapter = NewsAdapter()
        adapter.submitList(PlaceholderContent.ITEMS)
        binding.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        viewModel.fetchMostViewedNyNews()
    }

    private fun setObservers() {
        setBaseObserver(viewModel)
    }
}