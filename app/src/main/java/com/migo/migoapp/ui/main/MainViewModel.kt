package com.migo.migoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.migo.migoapp.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    private val _isFetch = MutableLiveData<Boolean>()
    val isFetch: LiveData<Boolean> = _isFetch

    fun setupFetchData(isFetch: Boolean) {
        _isFetch.value = isFetch
    }
}