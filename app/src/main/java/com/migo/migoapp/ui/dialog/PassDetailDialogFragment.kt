package com.migo.migoapp.ui.dialog

import android.os.Bundle
import android.view.View
import com.migo.migoapp.R
import com.migo.migoapp.model.db.vo.Pass
import com.migo.migoapp.model.emuns.PassStatus
import com.migo.migoapp.ui.base.BaseDialogFragment
import com.migo.migoapp.widget.utility.GeneralUtils
import kotlinx.android.synthetic.main.dialog_pass_detail.*

class PassDetailDialogFragment : BaseDialogFragment() {

    companion object {
        private const val KEY_DATA = "data"
        fun newInstance(pass: Pass): PassDetailDialogFragment {
            val fragment = PassDetailDialogFragment()
            val args = Bundle()
            args.putParcelable(KEY_DATA, pass)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pass = arguments?.getParcelable<Pass>(KEY_DATA)
        pass?.let {
            tv_pass_title.text = it.name

            when (it.status) {
                PassStatus.ACTIVATE -> {
                    tv_pass_status.text = getString(R.string.activate)
                    tv_pass_activated_title.visibility = View.GONE
                    tv_pass_activated.visibility = View.GONE
                    tv_pass_expire_title.visibility = View.GONE
                    tv_pass_expire.visibility = View.GONE

                }
                PassStatus.ACTIVATED -> {
                    tv_pass_status.text = getString(R.string.activated)
                    tv_pass_activated_title.visibility = View.VISIBLE
                    tv_pass_activated.visibility = View.VISIBLE
                    tv_pass_expire_title.visibility = View.VISIBLE
                    tv_pass_expire.visibility = View.VISIBLE
                }
                else -> {
                    tv_pass_status.text = getString(R.string.expire)
                    tv_pass_activated_title.visibility = View.VISIBLE
                    tv_pass_activated.visibility = View.VISIBLE
                    tv_pass_expire_title.visibility = View.VISIBLE
                    tv_pass_expire.visibility = View.VISIBLE
                }
            }

            tv_pass_activate.text = GeneralUtils.getDateTime(it.activateDate)
            tv_pass_activated.text = it.activatedDate?.let { date -> GeneralUtils.getDateTime(date) }
            tv_pass_expire.text = it.expireDate?.let { date -> GeneralUtils.getDateTime(date) }
        }

        btn_ok.setOnClickListener { dismiss() }
    }

    override fun getLayoutId(): Int {
        return R.layout.dialog_pass_detail
    }

    override fun isFullLayout(): Boolean {
        return false
    }
}