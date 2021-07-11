package com.migo.migoapp.ui.mypass

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.migo.migoapp.R
import com.migo.migoapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MyPassFragment : BaseFragment() {

    private val viewModel: MyPassViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel?.isFetch?.observe(viewLifecycleOwner, {
            if (it) {
                viewModel.getAllPass()
            }
        })

        viewModel.allPass.observe(viewLifecycleOwner, {
            Timber.d("@@pass size: ${it.size}")
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my_pass
    }
}