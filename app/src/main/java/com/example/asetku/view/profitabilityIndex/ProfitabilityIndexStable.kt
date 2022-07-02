package com.example.asetku.view.profitabilityIndex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityProfitabilityIndexMainStableBinding

class ProfitabilityIndexStable : AppCompatActivity() {

    private lateinit var binding: ActivityProfitabilityIndexMainStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfitabilityIndexMainStableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
    }
}