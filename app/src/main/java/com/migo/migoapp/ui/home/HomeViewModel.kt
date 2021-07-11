package com.migo.migoapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.migo.migoapp.model.api.ApiResult
import com.migo.migoapp.model.api.vo.ApiStatusItem
import com.migo.migoapp.model.repository.ApiRepository
import com.migo.migoapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : BaseViewModel() {

    private val _apiStatus = MutableLiveData<ApiResult<ApiStatusItem>>()
    val apiStatus: LiveData<ApiResult<ApiStatusItem>> = _apiStatus

//    private val _allPass = MutableLiveData<List<Pass>>()
//    val allPass: LiveData<List<Pass>> = _allPass

    fun getApiStatus() {
        viewModelScope.launch {
            apiRepository.getApiStatus()
                .onStart { _apiStatus.value = ApiResult.loading() }
                .catch { e -> _apiStatus.value = ApiResult.error(e) }
                .onCompletion { _apiStatus.value = ApiResult.loaded() }
                .collect { _apiStatus.value = ApiResult.success(it) }
        }
    }

//    fun getAllPass() {
//        viewModelScope.launch {
//            passRepository.getAllPass()
//                .collect { _allPass.value = it }
//        }
//    }
}
