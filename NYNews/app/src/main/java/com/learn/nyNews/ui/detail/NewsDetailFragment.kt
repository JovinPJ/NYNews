package com.learn.nyNews.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.learn.nyNews.databinding.FragmentNewsDetailBinding
import com.learn.nyNews.ui.base.BaseFragment

class NewsDetailFragment : BaseFragment() {

    private val viewModel: NewsDetailViewModel by viewModels()
    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    private var newsId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsId = arguments?.getString(ARG_ID)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        setBaseObserver(viewModel)
        newsId?.let {
            viewModel.fetchNyNews(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}