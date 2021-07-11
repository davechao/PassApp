package com.migo.migoapp.ui.mypass

import com.migo.migoapp.model.db.vo.Pass

class MyPassFuncListener(
    val onActivateClick: (pass: Pass) -> Unit = { },
    val onDetailClick: (pass: Pass) -> Unit = { },
)