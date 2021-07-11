package com.migo.migoapp.ui.mypass

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.migo.migoapp.R
import com.migo.migoapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_my_pass.*
import timber.log.Timber

@AndroidEntryPoint
class MyPassFragment : BaseFragment() {

    private val viewModel: MyPassViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myPassGroupAdapter = MyPassGroupAdapter(myPassFuncListener)
        rv_my_pass.also {
            it.setHasFixedSize(true)
            it.adapter = myPassGroupAdapter
        }

        mainViewModel?.isFetch?.observe(viewLifecycleOwner, {
            if (it) {
                viewModel.getAllPass()
            }
        })

        viewModel.myPass.observe(viewLifecycleOwner, {
            if (it.isEmpty()) {
                tv_empty_pass.visibility = View.VISIBLE
            } else {
                tv_empty_pass.visibility = View.GONE
            }
            myPassGroupAdapter.setupData(it)
        })

        viewModel.activateMyPass.observe(viewLifecycleOwner, {
            myPassGroupAdapter.updatePassStatus(viewModel.getActivatePassPos(), it)
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my_pass
    }

    private val myPassFuncListener by lazy {
        MyPassFuncListener(
            onActivateClick = { pos, pass ->
                viewModel.activateMyPass(pos, pass)
            },
            onDetailClick = {
                Timber.d("@@onDetailClick...")
            }
        )
    }
}