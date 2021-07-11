package com.migo.migoapp.ui.mypass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.migo.migoapp.R
import com.migo.migoapp.model.db.vo.Pass
import com.migo.migoapp.model.vo.PassListItem
import com.migo.migoapp.ui.viewholder.PassGroupViewHolder
import timber.log.Timber

class MyPassGroupAdapter(
    private val funcListener: MyPassFuncListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    private var passGroup: List<PassListItem> = arrayListOf()
    private var myPassAdapter: MyPassAdapter? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pass_group, parent, false)
        return PassGroupViewHolder(mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val passListItem = passGroup[position]
        val passes = passListItem.passes
        Timber.d("@@title: ${passListItem.title}")
        Timber.d("@@passes size: ${passes.size}")
        myPassAdapter = MyPassAdapter(passes, funcListener)
        holder as PassGroupViewHolder
        holder.groupTitle.text = passListItem.title.value
        holder.groupRecyclerView.also {
            it.setHasFixedSize(true)
            it.adapter = myPassAdapter
        }
    }

    override fun getItemCount(): Int {
        return passGroup.size
    }

    fun setupData(myPass: List<PassListItem>) {
        passGroup = myPass
        notifyDataSetChanged()
    }

    fun updatePassStatus(pos: Int, pass: Pass) {
        myPassAdapter?.updatePassStatus(pos, pass)
    }
}