package com.example.asetku.viewmodel

import androidx.lifecycle.ViewModel
import kotlin.math.pow

class AccountingViewModel : ViewModel() {

    fun PPstableCount(ii: Double, cf: Double): Double {
        return (ii / cf)
    }

    fun PPdifferentCount(ii: Double, cf1: Double, cf2: Double, cf3: Double): Double {
        val cfNew = DoubleArray(3)
        cfNew[0] = cf1
        cfNew[1] = cfNew[0] + cf2
        cfNew[2] = cfNew[1] + cf3

        return if (ii >= cfNew[1] && ii <= cfNew[2]) {
            (2.0 + ((ii - cfNew[1]) / ((cfNew[2]) - (cfNew[1])) * 1))
        } else {
            0.0
        }
    }

    fun NPVstableCount(ii: Double, cf: Double, y: Double, dr: Double): Double {
        var result = 0.0
        for (i in 1..y.toInt()) {
            result += (cf / (1 + dr / 100).pow(i))
        }
        return (result - ii.toInt())
    }

    fun NPVdifferentCount(
        ii: Double,
        dr: Double,
        cf1: Double,
        cf2: Double,
        cf3: Double
    ): Double {
        return ((cf1 / (1 + dr / 100)) + (cf2 / (1 + dr / 100).pow(2)) + (cf3 / (1 + dr / 100).pow(3)) - ii)
    }

    fun PIstableCount(ii: Double, cf: Double, y: Double, dr: Double): Double {
        val npv = NPVstableCount(ii, cf, y, dr)
        return ((npv + ii) / ii)
    }

    fun PIdifferentCount(
        ii: Double,
        dr: Double,
        cf1: Double,
        cf2: Double,
        cf3: Double
    ): Double {
        val npv = NPVdifferentCount(ii, dr, cf1, cf2, cf3)
        return (1 + (npv / ii))
    }

    // only 1 decimal after value
    fun IRRstableCount(
        ii1: Double,
        cf1: Double,
        y1: Double,
        dr1: Double,
        ii2: Double,
        cf2: Double,
        y2: Double,
        dr2: Double
    ): Double {
        val npv1 = NPVstableCount(ii1, cf1, y1, dr1)
        val npv2 = NPVstableCount(ii2, cf2, y2, dr2)
        return (dr1 + ((npv1 / (npv1 - npv2)) * (dr2 - dr1)))
    }

    fun IRRdifferentCount(
        ii1: Double,
        dr1: Double,
        cf11: Double,
        cf12: Double,
        cf13: Double,
        ii2: Double,
        dr2: Double,
        cf21: Double,
        cf22: Double,
        cf23: Double,
    ): Double {
        val npv1 = NPVdifferentCount(ii1, dr1, cf11, cf12, cf13)
        val npv2 = NPVdifferentCount(ii2, dr2, cf21, cf22, cf23)
        return (dr1 + ((npv1 / (npv1 - npv2)) * (dr2 - dr1)))
    }
}