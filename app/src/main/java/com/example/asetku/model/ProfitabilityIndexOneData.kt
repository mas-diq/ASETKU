package com.example.asetku.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfitabilityIndexOneData(
    val initialInvestment_1: String,
    val cashFlow_1: String,
    val year_1: String,
    val discountRate_1: String,
    val initialInvestment_2: String,
    val cashFlow_2: String,
    val year_2: String,
    val discountRate_2: String,
) : Parcelable
