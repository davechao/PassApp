package com.migo.migoapp.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.migo.migoapp.ui.wallet.WalletFragment
import com.migo.migoapp.ui.store.StoreFragment

class HomeViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StoreFragment()
            else -> WalletFragment()
        }
    }
}