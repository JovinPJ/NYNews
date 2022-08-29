package com.learn.nyNews.ui.home

import androidx.lifecycle.liveData
import com.learn.nyNews.domain.model.DataResult
import com.learn.nyNews.domain.usecases.FetchMostViewedNyNewsUsecase
import com.learn.nyNews.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val fetchMostViewedNyNewsUsecase: FetchMostViewedNyNewsUsecase) :
    BaseViewModel() {

    fun fetchMostViewedNyNews() = liveData {
        showProgress()
        when (val dataResult = fetchMostViewedNyNewsUsecase()) {

            is DataResult.Success -> {
                emit(dataResult.data)
            }
            is DataResult.Failure -> {
                showError(dataResult.error)
                if (dataResult.cachedData != null && dataResult.cachedData.isNotEmpty())
                    emit(dataResult.cachedData)
            }
        }
        hideProgress()
    }
}