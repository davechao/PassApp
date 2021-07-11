package com.migo.migoapp.ui.wallet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.migo.migoapp.R
import com.migo.migoapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_wallet.*
import timber.log.Timber

@AndroidEntryPoint
class WalletFragment : BaseFragment() {

    private val viewModel: WalletViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val walletGroupAdapter = WalletGroupAdapter(walletFuncListener)
        rv_wallet.also {
            it.setHasFixedSize(true)
            it.adapter = walletGroupAdapter
        }

        mainViewModel?.isFetch?.observe(viewLifecycleOwner, {
            if (it) {
                viewModel.getAllPass()
            }
        })

        viewModel.myPass.observe(viewLifecycleOwner, {
            if (it.isEmpty()) {
                tv_empty_wallet.visibility = View.VISIBLE
            } else {
                tv_empty_wallet.visibility = View.GONE
            }
            walletGroupAdapter.setupData(it)
        })

        viewModel.activateMyPass.observe(viewLifecycleOwner, {
            walletGroupAdapter.updatePassStatus(
                viewModel.getActivateGroupPos(), viewModel.getActivatePassPos(), it
            )
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_wallet
    }

    private val walletFuncListener by lazy {
        WalletFuncListener(
            onActivateClick = { groupPos, pos, pass ->
                viewModel.activateMyPass(groupPos, pos, pass)
            },
            onDetailClick = {
                Timber.d("@@onDetailClick...")
            }
        )
    }
}