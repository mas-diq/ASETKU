package com.example.asetku.view.profitabilityIndexOneCompany.Different

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityProfitabilityIndexOneDifferentResultBinding
import com.example.asetku.databinding.ActivityProfitabilityIndexOneStableResultBinding

class ProfitabilityIndexOneDifferentResult : AppCompatActivity() {

    lateinit var binding: ActivityProfitabilityIndexOneDifferentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfitabilityIndexOneDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}