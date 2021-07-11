package com.migo.migoapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.migo.migoapp.App
import com.migo.migoapp.R
import com.migo.migoapp.model.api.ApiResult.*
import com.migo.migoapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    companion object {
        val tabs = arrayListOf(
            App.self.getString(R.string.tab_store),
            App.self.getString(R.string.tab_my_pass),
        )
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewpager.adapter = HomeViewPagerAdapter(this)
        viewpager.registerOnPageChangeCallback(onPageChangeCallback)

        TabLayoutMediator(layout_tab, viewpager) { tab, position ->
            tab.text = tabs[position]
        }.attach()

        viewModel.apiStatus.observe(viewLifecycleOwner, {
            when (it) {
                is Loading -> {
                    tv_network_status.text =
                        getString(R.string.network_status_connecting)
                    tv_network_message.text =
                        getString(R.string.network_status_waiting)
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
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    private val onPageChangeCallback =
        object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(
                    position,
                    positionOffset,
                    positionOffsetPixels
                )
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 1) {
                    mainViewModel?.setupFetchData(true)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        }
}