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
}