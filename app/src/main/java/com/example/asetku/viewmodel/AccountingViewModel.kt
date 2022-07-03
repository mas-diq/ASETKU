package com.example.asetku.viewmodel

import androidx.lifecycle.ViewModel
import kotlin.math.pow

class AccountingViewModel : ViewModel() {

    fun PPstableCount(ii: Double, cf: Double, y: Double): Double {
        return (ii / cf * y)
    }

    fun PPdifferentCount(ii: Double, y: Double, cf1: Double, cf2: Double, cf3: Double): Double {
        val cfNew = DoubleArray(3)
        cfNew[0] = cf1
        cfNew[1] = cfNew[0] + cf2
        cfNew[2] = cfNew[1] + cf3

        return if (ii <= cfNew[1]) {
            (2 + ((ii - cfNew[0]) / (cfNew[1])) * y)
        } else {
            (3 + ((ii - cfNew[1]) / (cfNew[2])) * y)
        }
    }

    fun NPVstableCount(ii: Double, cf: Double, y: Double, dr: Double): Double {
        return ((cf / (1 + dr / 100).pow(y)) - ii)
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
        return (1 + (npv / ii))
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
        return (dr1 + (npv1 / (npv1 - npv2)) * (dr1 - dr1))
    }
}