package com.migo.migoapp.ui.mypass

import com.migo.migoapp.model.db.vo.Pass

class MyPassFuncListener(
    val onActivateClick: (pos: Int, pass: Pass) -> Unit = { _, _ -> },
    val onDetailClick: (pass: Pass) -> Unit = { },
)