package com.migo.migoapp.ui.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.migo.migoapp.R
import com.migo.migoapp.model.db.vo.Pass
import kotlinx.android.synthetic.main.item_pass.view.*

class StorePassAdapter(
    private val passes: List<Pass>,
    private val funcListener: StoreFuncListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pass, parent, false)
        return PassViewHolder(mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pass = passes[position]
        holder as PassViewHolder
        holder.passName.text = pass.name
        holder.passPrice.text = pass.price
        holder.passBtn.also {
            it.text = holder.passBtn.context.getString(R.string.buy)
            it.setOnClickListener {
                funcListener.onBuyClick()
            }
        }
    }

    override fun getItemCount(): Int {
        return passes.size
    }

    class PassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var passName: TextView = itemView.tv_pass_name
        var passPrice: TextView = itemView.tv_pass_price
        var passBtn: Button = itemView.btn_action
    }
}