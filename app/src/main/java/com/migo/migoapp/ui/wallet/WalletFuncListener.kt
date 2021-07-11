package com.migo.migoapp.ui.wallet

import com.migo.migoapp.model.db.vo.Pass

class WalletFuncListener(
    val onActivateClick: (groupPos: Int, passPos: Int, pass: Pass) -> Unit = { _, _, _ -> },
    val onDetailClick: (pass: Pass) -> Unit = { },
)