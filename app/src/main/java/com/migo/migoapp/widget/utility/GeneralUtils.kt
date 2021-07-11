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

    fun getExpireTimeByDay(date: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DATE, 1)
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    fun getExpireTimeByHour(date: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.HOUR_OF_DAY, 1)
        return calendar.time
    }
}