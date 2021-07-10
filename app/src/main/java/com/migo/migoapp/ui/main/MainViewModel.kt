package com.migo.migoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.migo.migoapp.model.emuns.ApiEnv
import com.migo.migoapp.model.emuns.NetworkType
import com.migo.migoapp.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    private val _apiEnv = MutableLiveData<ApiEnv>()
    val apiEnv: LiveData<ApiEnv> = _apiEnv

    private val _networkAvailable = MutableLiveData(false)
    val networkAvailable: LiveData<Boolean> = _networkAvailable

    private val _networkType = MutableLiveData(NetworkType.NONE)
    val networkType: LiveData<NetworkType> = _networkType

    fun setupApiEnv(env: ApiEnv) {
        _apiEnv.postValue(env)
    }

    fun setupNetworkAvailable(isAvailable: Boolean) {
        _networkAvailable.postValue(isAvailable)
    }

    fun setupNetworkType(type: NetworkType) {
        _networkType.postValue(type)
    }
}