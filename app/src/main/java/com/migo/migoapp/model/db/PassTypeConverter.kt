package com.migo.migoapp.model.db

import androidx.room.TypeConverter
import com.migo.migoapp.model.emuns.PassType

class PassTypeConverter {

    @TypeConverter
    fun fromPassType(type: PassType): Int {
        return type.value
    }

    @TypeConverter
    fun toPassType(value: Int): PassType {
        return when (value) {
            0 -> PassType.DAY
            else -> PassType.HOUR
        }
    }
}