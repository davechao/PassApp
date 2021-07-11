package com.migo.migoapp.ui.store

import com.migo.migoapp.model.db.vo.Pass

class StoreFuncListener(
    val onBuyClick: (pass: Pass) -> Unit = { },
)