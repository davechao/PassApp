package com.migo.migoapp.model.vo

import com.migo.migoapp.model.db.vo.Pass
import com.migo.migoapp.model.emuns.PassTitleType

data class PassListItem(
    val title: PassTitleType,
    val passes: ArrayList<Pass> = arrayListOf()
)