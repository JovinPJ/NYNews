package com.learn.nyNews.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.nyNews.R
import com.learn.nyNews.domain.model.ApiError
import com.learn.nyNews.domain.model.ERROR_CODE_NETWORK
import com.learn.nyNews.domain.model.ERROR_CODE_SERVER
import com.learn.nyNews.domain.model.ERROR_CODE_UNKNOWN
import com.learn.nyNews.ui.models.ToastMessage
import kotlinx.coroutines.CoroutineExceptionHandler
import java.net.UnknownHostException

abstract class BaseViewModel : ViewModel() {
    protected val handler = CoroutineExceptionHandler { _, exception ->
        val msg = "Caught $exception"
        hideProgress()
        if (exception is UnknownHostException)
            showToast(toastRes = R.string.check_internet)
        else showToast(toastMsg = msg)
    }

    private val toastMessageLiveData = MutableLiveData<ToastMessage>()
    private val progressBarLiveData = MutableLiveData<Boolean>()

    fun getToastLiveData(): LiveData<ToastMessage> {
        return toastMessageLiveData
    }

    fun getProgressBarLiveData(): LiveData<Boolean> {
        return progressBarLiveData
    }

    protected fun showToast(toastMsg: String? = null, toastRes: Int? = null) {
        toastMessageLiveData.postValue(
            ToastMessage(
                message = toastMsg,
                messageRes = toastRes
            )
        )
    }

    protected fun showProgress() {
        progressBarLiveData.postValue(true)
    }

    protected fun hideProgress() {
        progressBarLiveData.postValue(false)
    }

    protected fun showError(error: ApiError) {
        when (error.errorCode) {
            ERROR_CODE_NETWORK -> showToast(toastRes = R.string.check_internet)
            ERROR_CODE_SERVER, ERROR_CODE_UNKNOWN -> if (error.errorMessage != null && error.errorMessage.isNotEmpty())
                showToast(error.errorMessage) else showToast(toastRes = R.string.unknown_error)

        }
    }

}