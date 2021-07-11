package com.migo.migoapp.ui.store

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.migo.migoapp.R
import com.migo.migoapp.ui.base.BaseFragment
import com.migo.migoapp.widget.utility.GeneralUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_store.*

@AndroidEntryPoint
class StoreFragment : BaseFragment() {

    private val viewModel: StoreViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_shop.also {
            it.setHasFixedSize(true)
            it.adapter = StorePassGroupAdapter(
                viewModel.getStorePass(),
                storeFuncListener
            )
        }

        viewModel.buyPass.observe(viewLifecycleOwner, {
            GeneralUtils.showToast(requireContext(), "${getString(R.string.purchase)} ${it.name}")
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_store
    }

    private val storeFuncListener by lazy {
        StoreFuncListener(
            onBuyClick = { viewModel.buyPass(it) }
        )
    }
}