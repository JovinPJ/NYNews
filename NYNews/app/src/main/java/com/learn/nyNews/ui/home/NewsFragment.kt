package com.learn.nyNews.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.learn.nyNews.R
import com.learn.nyNews.databinding.FragmentNewsBinding
import com.learn.nyNews.ui.base.BaseFragment

class NewsFragment : BaseFragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.adapter = NewsAdapter { article ->
            findNavController().navigate(
                R.id.action_newsList_to_detail, bundleOf(ARG_ID to article.title)
            )
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        setBaseObserver(viewModel)
        viewModel.mostViewedNewsLiveData.observe(viewLifecycleOwner) {
            (binding.adapter as NewsAdapter).submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}