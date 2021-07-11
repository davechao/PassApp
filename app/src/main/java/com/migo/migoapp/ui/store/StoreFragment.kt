package com.migo.migoapp.ui.store

import android.os.Bundle
import android.view.View
import com.migo.migoapp.R
import com.migo.migoapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class StoreFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("@@StoreFragment...")
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_store
    }
}