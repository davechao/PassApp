package com.migo.migoapp.ui.viewholder

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_pass.view.*

class PassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var passName: TextView = itemView.tv_pass_name
    var passPrice: TextView = itemView.tv_pass_price
    var passBtn: Button = itemView.btn_action
    var passLayout: ConstraintLayout = itemView.layout_pass
}