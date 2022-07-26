package com.example.asetku.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityLoadingScreenBinding
import com.example.asetku.view.internalRateOfReturnMultipleCompany.InternalRateOfReturnDifferentResult
import com.example.asetku.view.internalRateOfReturnMultipleCompany.InternalRateOfReturnStableResult
import com.example.asetku.view.netPresentValueMultipleCompany.NetPresentValueDifferentResult
import com.example.asetku.view.netPresentValueMultipleCompany.NetPresentValueStableResult
import com.example.asetku.view.paybackPeriodMultipleCompany.PaybackPeriodDifferentResult
import com.example.asetku.view.paybackPeriodMultipleCompany.PaybackPeriodStableResult
import com.example.asetku.view.profitabilityIndexMultipleCompany.ProfitabilityIndexDifferentResult
import com.example.asetku.view.profitabilityIndexMultipleCompany.ProfitabilityIndexStableResult

class LoadingScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoadingScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoadingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        val dir = intent.extras?.getString("dir")

        Handler(mainLooper).postDelayed({
            var move = intent
            when (dir) {
                "ppStable" -> move = Intent(this, PaybackPeriodStableResult::class.java)
                "ppDifferent" -> move = Intent(this, PaybackPeriodDifferentResult::class.java)
                "piStable" -> move = Intent(this, ProfitabilityIndexStableResult::class.java)
                "piDifferent" -> move = Intent(this, ProfitabilityIndexDifferentResult::class.java)
                "npvStable" -> move = Intent(this, NetPresentValueStableResult::class.java)
                "npvDifferent" -> move = Intent(this, NetPresentValueDifferentResult::class.java)
                "irrStable" -> move = Intent(this, InternalRateOfReturnStableResult::class.java)
                "irrDifferent" -> move =
                    Intent(this, InternalRateOfReturnDifferentResult::class.java)
            }
            startActivity(move)
            finish()
        }, 2700)
    }
}