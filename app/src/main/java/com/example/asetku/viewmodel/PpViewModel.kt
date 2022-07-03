package com.example.asetku.viewmodel

import androidx.lifecycle.ViewModel

class PpViewModel : ViewModel() {

    fun stableCount(ii: Double, cf: Double, y: Double): Double {
        return (ii / cf * y)
    }
}