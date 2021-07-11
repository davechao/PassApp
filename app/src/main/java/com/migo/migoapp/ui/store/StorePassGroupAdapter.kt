package com.migo.migoapp.ui.store

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.migo.migoapp.R
import com.migo.migoapp.model.vo.PassListItem
import com.migo.migoapp.ui.viewholder.PassGroupViewHolder

class StorePassGroupAdapter(
    private val passGroup: List<PassListItem>,
    private val funcListener: StoreFuncListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pass_group, parent, false)
        return PassGroupViewHolder(mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val passListItem = passGroup[position]

        holder as PassGroupViewHolder
        holder.groupTitle.text = passListItem.title

        holder.groupRecyclerView.also {
            it.setHasFixedSize(true)
            it.adapter = StorePassAdapter(passListItem.passes, funcListener)
        }
    }

    override fun getItemCount(): Int {
        return passGroup.size
    }
}