package com.example.asetku.view.paybackPeriodOneCompany.Different

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityPaybackPeriodOneDifferentBinding

class PaybackPeriodOneDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodOneDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodOneDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}