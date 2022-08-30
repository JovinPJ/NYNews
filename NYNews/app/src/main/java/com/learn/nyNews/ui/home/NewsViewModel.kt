package com.learn.nyNews.ui.home

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.model.DataResult
import com.learn.nyNews.domain.usecases.FetchMostViewedNyNewsUsecase
import com.learn.nyNews.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val fetchMostViewedNyNewsUsecase: FetchMostViewedNyNewsUsecase) :
    BaseViewModel() {

    val emptyNewsViewState = ObservableBoolean(false)
    var mostViewedNewsLiveData: LiveData<List<Article>> = MutableLiveData()

    init {
        mostViewedNewsLiveData = fetchMostViewedNyNews()
    }

    fun fetchMostViewedNyNews() = liveData {
        showProgress()
        when (val dataResult = fetchMostViewedNyNewsUsecase()) {

            is DataResult.Success -> {
                setViewState(dataResult.data)
                emit(dataResult.data)
            }
            is DataResult.Failure -> {
                showError(dataResult.error)
                setViewState(dataResult.cachedData)
                if (dataResult.cachedData != null && dataResult.cachedData.isNotEmpty())
                    emit(dataResult.cachedData)
            }
        }
        hideProgress()
    }

    private fun setViewState(list: List<Article>?) {
        if (list == null || list.isEmpty())
            emptyNewsViewState.set(true)
        else emptyNewsViewState.set(false)
    }
}