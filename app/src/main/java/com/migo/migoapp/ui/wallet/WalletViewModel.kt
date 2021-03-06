package com.migo.migoapp.ui.wallet

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
class WalletViewModel @Inject constructor(
    private val passRepository: PassRepository
) : BaseViewModel() {

    private val _myPass = MutableLiveData<List<PassListItem>>()
    val myPass: LiveData<List<PassListItem>> = _myPass

    private val _activateMyPass = MutableLiveData<Pass>()
    val activateMyPass: LiveData<Pass> = _activateMyPass

    private var _activatePassPos: Int = -1
    private var _activateGroupPos: Int = -1

    fun getAllPass() {
        viewModelScope.launch {
            passRepository.getMyPass()
                .collect { _myPass.value = it }
        }
    }

    fun activateMyPass(groupPos: Int, pos: Int, pass: Pass) {
        viewModelScope.launch {
            passRepository.activateMyPass(pass)
                .collect {
                    _activateGroupPos = groupPos
                    _activatePassPos = pos
                    _activateMyPass.value = it
                }
        }
    }

    fun getActivatePassPos(): Int {
        return _activatePassPos
    }

    fun getActivateGroupPos(): Int {
        return _activateGroupPos
    }
}