package com.example.asetku.view.paybackPeriod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityPaybackPeriodDifferentBinding

class PaybackPeriodDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
    }
}