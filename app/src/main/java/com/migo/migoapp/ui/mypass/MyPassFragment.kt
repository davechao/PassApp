package com.migo.migoapp.ui.mypass

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.migo.migoapp.R
import com.migo.migoapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MyPassFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("@@MyPassFragment...")

        mainViewModel?.isFetch?.observe(viewLifecycleOwner, {
            if(it) {
                Timber.d("@@isFetch...")
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my_pass
    }
}