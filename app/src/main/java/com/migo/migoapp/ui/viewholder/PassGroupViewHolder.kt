package com.migo.migoapp.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_pass_group.view.*

class PassGroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var groupTitle: TextView = itemView.tv_group_title
    var groupRecyclerView: RecyclerView = itemView.rv_group
}