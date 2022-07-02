package com.example.asetku.view.profitabilityIndex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityProfitabilityIndexMainDifferentBinding

class ProfitabilityIndexDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityProfitabilityIndexMainDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfitabilityIndexMainDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

    }
}