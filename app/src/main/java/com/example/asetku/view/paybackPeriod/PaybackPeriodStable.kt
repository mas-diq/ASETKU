package com.example.asetku.view.paybackPeriod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityPaybackPeriodStableBinding

class PaybackPeriodStable : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodStableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

    }
}