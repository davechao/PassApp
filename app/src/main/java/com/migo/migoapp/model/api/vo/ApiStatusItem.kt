package com.migo.migoapp.model.api.vo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiStatusItem(

    @SerializedName("status")
    val status: Int,

    @SerializedName("message")
    val message: String

) : Parcelable