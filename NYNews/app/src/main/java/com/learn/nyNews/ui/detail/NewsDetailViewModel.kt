package com.learn.nyNews.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.usecases.FetchNyNewsUsecase
import com.learn.nyNews.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(private val fetchNyNewsUsecase: FetchNyNewsUsecase) :
    BaseViewModel() {

    private val articleLiveData = MutableLiveData<Article>()
    fun getArticle(): LiveData<Article> = articleLiveData

    fun fetchNyNews(id: String) {
        viewModelScope.launch {
            fetchNyNewsUsecase(id).let {
                articleLiveData.postValue(it)
            }
        }
    }

}