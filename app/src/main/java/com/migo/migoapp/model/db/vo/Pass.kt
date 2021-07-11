package com.migo.migoapp.model.db.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pass")
data class Pass(
    @PrimaryKey var id: String = "",
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "price") var price: String? = null
)