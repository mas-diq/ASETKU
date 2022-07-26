package com.example.asetku.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InternalRateOfReturnOneData(
    val initialInvestment: String,
    val cashFlow: String,
    val year: String,
    val discountRate: String,
) : Parcelable