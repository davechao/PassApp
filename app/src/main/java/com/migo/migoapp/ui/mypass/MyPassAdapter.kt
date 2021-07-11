package com.migo.migoapp.ui.mypass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.migo.migoapp.R
import com.migo.migoapp.model.db.vo.Pass
import com.migo.migoapp.ui.viewholder.PassViewHolder

class MyPassAdapter(
    private val passes: List<Pass>,
    private val funcListener: MyPassFuncListener
)  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
            it.text = holder.passBtn.context.getString(R.string.activate)
            it.setOnClickListener { funcListener.onActivateClick(pass) }
        }
        holder.passLayout.setOnClickListener { funcListener.onDetailClick(pass) }
    }

    override fun getItemCount(): Int {
        return passes.size
    }
}