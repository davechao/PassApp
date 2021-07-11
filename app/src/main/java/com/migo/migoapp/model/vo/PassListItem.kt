package com.migo.migoapp.model.vo

import com.migo.migoapp.model.db.vo.Pass

data class PassListItem(
    val title: String = "",
    val passes: List<Pass> = arrayListOf()
)