package com.migo.migoapp.ui.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.migo.migoapp.R
import com.migo.migoapp.model.vo.PassListItem
import kotlinx.android.synthetic.main.item_pass_group.view.*

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

    class PassGroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var groupTitle: TextView = itemView.tv_group_title
        var groupRecyclerView: RecyclerView = itemView.rv_group
    }
}