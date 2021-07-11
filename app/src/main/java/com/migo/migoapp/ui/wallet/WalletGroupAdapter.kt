package com.migo.migoapp.ui.wallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.migo.migoapp.R
import com.migo.migoapp.model.db.vo.Pass
import com.migo.migoapp.model.vo.PassListItem
import com.migo.migoapp.ui.viewholder.PassGroupViewHolder

class WalletGroupAdapter(
    private val funcListener: WalletFuncListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var passGroup: List<PassListItem> = arrayListOf()
    private var walletAdapterMap = hashMapOf<Int, WalletAdapter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pass_group, parent, false)
        return PassGroupViewHolder(mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val passListItem = passGroup[position]
        val walletAdapter = WalletAdapter(position, passListItem.passes, funcListener)
        walletAdapterMap[position] = walletAdapter

        holder as PassGroupViewHolder
        holder.groupTitle.text = passListItem.title.value
        holder.groupRecyclerView.also {
            it.setHasFixedSize(true)
            it.adapter = walletAdapter
        }
    }

    override fun getItemCount(): Int {
        return passGroup.size
    }

    fun setupData(myPass: List<PassListItem>) {
        passGroup = myPass
        notifyDataSetChanged()
    }

    fun updatePassStatus(groupPod: Int, passPos: Int, pass: Pass) {
        walletAdapterMap[groupPod]?.updatePassStatus(passPos, pass)
    }
}