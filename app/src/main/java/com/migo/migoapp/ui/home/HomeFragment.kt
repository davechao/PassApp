package com.migo.migoapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.migo.migoapp.R
import com.migo.migoapp.model.api.ApiResult.*
import com.migo.migoapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apiStatus.observe(viewLifecycleOwner, {
            when (it) {
                is Loading -> {
                    tv_network_status.text =
                        getString(R.string.network_status_connecting)
                    tv_network_message.text = getString(R.string.network_status_waiting)
                }
                is Loaded -> {
                    // DO-Nothing
                }
                is Success -> {
                    it.result?.let { item ->
                        tv_network_status.text = item.status.toString()
                        tv_network_message.text = item.message
                    }
                }
                is Error -> {
                    tv_network_status.text =
                        getString(R.string.network_status_disconnect)
                    tv_network_message.text = it.throwable.message.toString()
                }
            }
        })

        viewModel.getApiStatus()

//        rv_wallet.also {
//            it.setHasFixedSize(true)
//            it.adapter = detailAdapter
//        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }
}