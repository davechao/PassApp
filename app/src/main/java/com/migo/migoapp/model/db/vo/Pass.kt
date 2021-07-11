package com.migo.migoapp.model.db.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.migo.migoapp.model.db.PassTypeConverter
import com.migo.migoapp.model.emuns.PassType

@Entity(tableName = "pass")
data class Pass(
    @PrimaryKey
    var id: String = "",

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "price")
    var price: String? = null,

    @ColumnInfo(name = "type")
    @TypeConverters(PassTypeConverter::class)
    var type: PassType? = null,

    @ColumnInfo(name = "isActivate")
    var isActivate: Boolean = false

)