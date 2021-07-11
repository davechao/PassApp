package com.migo.migoapp.ui.mypass

import com.migo.migoapp.model.db.vo.Pass

class MyPassFuncListener(
    val onActivateClick: (groupPos: Int, passPos: Int, pass: Pass) -> Unit = { _, _, _ -> },
    val onDetailClick: (pass: Pass) -> Unit = { },
)