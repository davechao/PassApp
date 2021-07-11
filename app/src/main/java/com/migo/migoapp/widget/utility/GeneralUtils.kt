package com.migo.migoapp.widget.utility

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

object GeneralUtils {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    fun showToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun generateId(): String {
        return UUID.randomUUID().toString()
    }

    fun getDateTime(date: Date): String {
        return formatter.format(date)
    }
}