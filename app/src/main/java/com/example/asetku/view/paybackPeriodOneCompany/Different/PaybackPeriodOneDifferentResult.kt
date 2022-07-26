package com.example.asetku.view.paybackPeriodOneCompany.Different

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityPaybackPeriodOneDifferentResultBinding

class PaybackPeriodOneDifferentResult : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodOneDifferentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodOneDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}