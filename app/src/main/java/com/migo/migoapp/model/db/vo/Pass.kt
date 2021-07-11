package com.migo.migoapp.model.db.vo

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.migo.migoapp.model.emuns.PassStatus
import com.migo.migoapp.model.emuns.PassType
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "pass")
@Parcelize
data class Pass(
    @PrimaryKey
    var id: String = "",

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "price")
    var price: String? = null,

    @ColumnInfo(name = "type")
    var type: PassType? = null,

    @ColumnInfo(name = "status")
    var status: PassStatus = PassStatus.ACTIVATE,

    @ColumnInfo(name = "activateDate")
    var activateDate: Date = Date(),

    @ColumnInfo(name = "activatedDate")
    var activatedDate: Date? = null,

    @ColumnInfo(name = "expireDate")
    var expireDate: Date? = null,
): Parcelable