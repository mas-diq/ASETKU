package com.example.asetku.view.paybackPeriodOneCompany.Stable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityPaybackPeriodOneStableBinding

class PaybackPeriodOneStable : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodOneStableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodOneStableBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}