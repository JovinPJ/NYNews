package com.learn.nyNews.ui.base

import androidx.fragment.app.Fragment
import com.learn.nyNews.ui.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    protected fun setBaseObserver(viewModel: BaseViewModel) {
        viewModel.getToastLiveData().observe(viewLifecycleOwner) { toastMsg ->
            showToast(
                message = toastMsg.message,
                messageRes = toastMsg.messageRes
            )
        }
    }
}