package com.example.asetku.view.profitabilityIndexOneCompany.Different

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityProfitabilityIndexOneDifferentBinding

class ProfitabilityIndexOneDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityProfitabilityIndexOneDifferentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfitabilityIndexOneDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}