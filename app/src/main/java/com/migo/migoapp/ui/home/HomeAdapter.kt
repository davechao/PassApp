package com.migo.migoapp.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    companion object {
//        const val VIEW_TYPE_HEADER = 0
//        const val VIEW_TYPE_WALLET = 1
//    }
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): RecyclerView.ViewHolder {
//        return when (viewType) {
//            VIEW_TYPE_HEADER -> {
//                val mView = LayoutInflater.from(parent.context)
//                    .inflate(R.layout.item_detail, parent, false)
//                DetailViewHolder(mView)
//            }
//            else -> {
//
//            }
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return when (position) {
//            0 -> VIEW_TYPE_HEADER
//            else -> VIEW_TYPE_WALLET
//        }
//    }
//
//    override fun onBindViewHolder(
//        holder: RecyclerView.ViewHolder,
//        position: Int
//    ) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
//}