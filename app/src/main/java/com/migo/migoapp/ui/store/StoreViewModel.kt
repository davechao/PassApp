package com.migo.migoapp.ui.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.migo.migoapp.model.db.vo.Pass
import com.migo.migoapp.model.repository.PassRepository
import com.migo.migoapp.model.vo.PassListItem
import com.migo.migoapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val passRepository: PassRepository
) : BaseViewModel() {

    private val _savePass = MutableLiveData<Nothing>()
    val savePass: LiveData<Nothing> = _savePass

    fun getStorePass(): ArrayList<PassListItem> {
        return passRepository.fetchStorePass()
    }

    fun savePass(pass: Pass) {
        viewModelScope.launch {
            passRepository.savePass(pass)
                .collect { _savePass.value = it }
        }
    }

}