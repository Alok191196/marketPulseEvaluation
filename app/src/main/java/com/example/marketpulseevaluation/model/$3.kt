package com.example.marketpulseevaluation.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class `$3`(
    var type: String,
    @Json(name = "study_type") var studyType: String? = null,
    @Json(name = "parameter_name") var parameterName: String? = null,
    @Json(name = "min_value") var minValue: Int? = null,
    @Json(name = "max_value") var maxValue: Int? = null,
    @Json(name = "default_value") var defaultValue: Int? = null,
    var values: List<Double>? = null
) : Parcelable