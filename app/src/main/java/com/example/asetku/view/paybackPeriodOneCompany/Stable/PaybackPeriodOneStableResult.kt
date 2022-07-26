package com.example.asetku.view.paybackPeriodOneCompany.Stable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityPaybackPeriodOneStableResultBinding

class PaybackPeriodOneStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodOneStableResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodOneStableResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}