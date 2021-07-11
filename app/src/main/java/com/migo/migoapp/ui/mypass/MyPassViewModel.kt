package com.migo.migoapp.ui.mypass

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
class MyPassViewModel @Inject constructor(
    private val passRepository: PassRepository
) : BaseViewModel() {

    private val _myPass = MutableLiveData<List<PassListItem>>()
    val myPass: LiveData<List<PassListItem>> = _myPass

    fun getAllPass() {
        viewModelScope.launch {
            passRepository.getMyPass()
                .collect { _myPass.value = it }
        }
    }
}