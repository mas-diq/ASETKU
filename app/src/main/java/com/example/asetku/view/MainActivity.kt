package com.example.asetku.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityMainBinding
import com.example.asetku.view.internalRateOfReturn.InternalRateOfReturnDifferent
import com.example.asetku.view.internalRateOfReturn.InternalRateOfReturnStable
import com.example.asetku.view.netPresentValue.NetPresentValueDifferent
import com.example.asetku.view.netPresentValue.NetPresentValueStable
import com.example.asetku.view.paybackPeriod.PaybackPeriodDifferent
import com.example.asetku.view.paybackPeriod.PaybackPeriodStable
import com.example.asetku.view.profitabilityIndex.ProfitabilityIndexDifferent
import com.example.asetku.view.profitabilityIndex.ProfitabilityIndexStable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        moveToPP()
        moveToNPV()
        moveToPI()
        moveToIRR()
        // 4 Method
    }

    private fun moveToIRR() {
        binding.cardViewIrr.setOnClickListener {
            if (binding.switch1.isChecked) {
                val move = Intent(this, InternalRateOfReturnDifferent::class.java)
                startActivity(move)
            } else {
                val move = Intent(this, InternalRateOfReturnStable::class.java)
                startActivity(move)
            }
        }
    }

    private fun moveToPI() {
        binding.cardViewPi.setOnClickListener {
            if (binding.switch1.isChecked) {
                val move = Intent(this, ProfitabilityIndexDifferent::class.java)
                startActivity(move)
            } else {
                val move = Intent(this, ProfitabilityIndexStable::class.java)
                startActivity(move)
            }
        }
    }

    private fun moveToNPV() {
        binding.cardViewNpv.setOnClickListener {
            if (binding.switch1.isChecked) {
                val move = Intent(this, NetPresentValueDifferent::class.java)
                startActivity(move)
            } else {
                val move = Intent(this, NetPresentValueStable::class.java)
                startActivity(move)
            }
        }
    }

    private fun moveToPP() {
        binding.cardViewPp.setOnClickListener {
            if (binding.switch1.isChecked) {
                val move = Intent(this, PaybackPeriodDifferent::class.java)
                startActivity(move)
            } else {
                val move = Intent(this, PaybackPeriodStable::class.java)
                startActivity(move)
            }
        }
    }
}