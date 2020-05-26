package com.example.marketpulseevaluation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Criteria(
    var type : String,
    var text : String,
    var variable : Variable? = null
) : Parcelable