package com.learn.nyNews.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.learn.nyNews.R
import com.learn.nyNews.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class NewsViewModel : BaseViewModel() {


    fun fetchMostViewedNyNews() {

        try {
            showProgress()
            viewModelScope.launch(handler) {
                hideProgress()
            }
        } catch (e: Exception) {
            Log.e("NewsViewModel", "fetch news Caught $e")
            hideProgress()
            e.message?.let {
                showToast(e.message)
            } ?: showToast(toastRes = R.string.unknown_error)

        }
    }
}