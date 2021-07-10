package com.migo.migoapp.widget.utility

import android.content.Context
import android.widget.Toast
import java.util.*

object GeneralUtils {
    fun showToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun generateId(): String {
        return UUID.randomUUID().toString()
    }
}