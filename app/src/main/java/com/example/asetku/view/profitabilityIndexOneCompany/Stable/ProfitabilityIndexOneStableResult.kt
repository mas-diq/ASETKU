package com.example.asetku.view.profitabilityIndexOneCompany.Stable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityProfitabilityIndexOneStableResultBinding

class ProfitabilityIndexOneStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityProfitabilityIndexOneStableResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfitabilityIndexOneStableResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

    }
}