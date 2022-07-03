package com.example.asetku.viewmodel

import androidx.lifecycle.ViewModel

class PpViewModel : ViewModel() {

    fun stableCount(ii: Double, cf: Double, y: Double): Double {
        return (ii / cf * y)
    }

    fun differentCount(ii: Double, y: Double, cf1: Double, cf2: Double, cf3: Double): Double {
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
}