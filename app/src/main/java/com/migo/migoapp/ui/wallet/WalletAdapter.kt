package com.migo.migoapp.ui.wallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.migo.migoapp.R
import com.migo.migoapp.model.db.vo.Pass
import com.migo.migoapp.model.emuns.PassStatus
import com.migo.migoapp.model.emuns.PassType
import com.migo.migoapp.ui.viewholder.PassViewHolder
import com.migo.migoapp.widget.utility.GeneralUtils
import java.util.*

class WalletAdapter(
    private val groupPos: Int,
    private val passes: ArrayList<Pass>,
    private val funcListener: WalletFuncListener
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

        when (pass.status) {
            PassStatus.ACTIVATE -> {
                holder.passBtn.text =
                    holder.passBtn.context.getString(R.string.activate)
                holder.passBtn.isEnabled = true
            }
            PassStatus.ACTIVATED -> {
                holder.passBtn.text =
                    holder.passBtn.context.getString(R.string.activated)
                holder.passBtn.isEnabled = false
            }
            else -> {
                holder.passBtn.text =
                    holder.passBtn.context.getString(R.string.expire)
                holder.passBtn.isEnabled = false
            }
        }

        holder.passBtn.setOnClickListener {
            pass.status = PassStatus.ACTIVATED
            pass.activatedDate = Date()

            if (pass.type == PassType.DAY) {
                pass.expireDate = GeneralUtils.getExpireTimeByDay(Date())
            } else {
                pass.expireDate = GeneralUtils.getExpireTimeByHour(Date())
            }

            funcListener.onActivateClick(groupPos, position, pass)
        }

        holder.passLayout.setOnClickListener { funcListener.onDetailClick(pass) }
    }

    override fun getItemCount(): Int {
        return passes.size
    }

    fun updatePassStatus(pos: Int, pass: Pass) {
        passes[pos] = pass
        notifyItemChanged(pos)
    }
}