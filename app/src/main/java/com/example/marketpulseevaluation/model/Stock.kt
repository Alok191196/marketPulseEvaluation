package com.example.marketpulseevaluation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class  Stock (
    var id : Int,
    var name : String,
    var tag : String,
    var color : String,
    var criteria : List<Criteria>
) : Parcelable