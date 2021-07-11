package com.migo.migoapp.ui.store

import com.migo.migoapp.model.repository.PassRepository
import com.migo.migoapp.model.vo.PassListItem
import com.migo.migoapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val passRepository: PassRepository
) : BaseViewModel() {

    fun getStorePass(): ArrayList<PassListItem> {
        return passRepository.fetchStorePass()
    }


}