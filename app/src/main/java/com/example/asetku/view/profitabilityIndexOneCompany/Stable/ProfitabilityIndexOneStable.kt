package com.example.asetku.view.profitabilityIndexOneCompany.Stable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityProfitabilityIndexOneStableBinding

class ProfitabilityIndexOneStable : AppCompatActivity() {

    lateinit var binding: ActivityProfitabilityIndexOneStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfitabilityIndexOneStableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
    }
}