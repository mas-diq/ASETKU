package com.example.asetku.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityMainBinding
import com.example.asetku.view.fourMethodMultipleCompany.FourMethodStable
import com.example.asetku.view.internalRateOfReturnMultipleCompany.InternalRateOfReturnDifferent
import com.example.asetku.view.internalRateOfReturnMultipleCompany.InternalRateOfReturnStable
import com.example.asetku.view.internalRateOfReturnOneCompany.Stable.InternalRateOfReturnOneStable
import com.example.asetku.view.netPresentValueMultipleCompany.NetPresentValueDifferent
import com.example.asetku.view.netPresentValueMultipleCompany.NetPresentValueStable
import com.example.asetku.view.netPresentValueOneCompany.Stable.NetPresentValueOneStable
import com.example.asetku.view.paybackPeriodMultipleCompany.PaybackPeriodDifferent
import com.example.asetku.view.paybackPeriodMultipleCompany.PaybackPeriodStable
import com.example.asetku.view.paybackPeriodOneCompany.Stable.PaybackPeriodOneStable
import com.example.asetku.view.profitabilityIndexMultipleCompany.ProfitabilityIndexDifferent
import com.example.asetku.view.profitabilityIndexMultipleCompany.ProfitabilityIndexStable
import com.example.asetku.view.profitabilityIndexOneCompany.Stable.ProfitabilityIndexOneStable

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
        moveToFour()
    }

    private fun moveToFour() {
        binding.cardViewFourMethod.setOnClickListener {
            if (binding.CommpanySwitch.isChecked) {
                val move = Intent(this, FourMethodStable::class.java)
                startActivity(move)
            } else {
                val move = Intent(this, UnderConstruction::class.java)
                startActivity(move)
            }
        }
    }

    private fun moveToIRR() {
        binding.cardViewIrr.setOnClickListener {
            if (binding.CashFlowSwitch.isChecked && binding.CommpanySwitch.isChecked) {
                val move = Intent(this, InternalRateOfReturnDifferent::class.java)
                startActivity(move)
            } else if (binding.CommpanySwitch.isChecked) {
                val move = Intent(this, InternalRateOfReturnStable::class.java)
                startActivity(move)
            } else if (binding.CashFlowSwitch.isChecked) {
                val move = Intent(this, UnderConstruction::class.java)
                startActivity(move)
            } else {
                val move = Intent(this, InternalRateOfReturnOneStable::class.java)
                startActivity(move)
            }
        }
    }

    private fun moveToPI() {
        binding.cardViewPi.setOnClickListener {
            if (binding.CashFlowSwitch.isChecked && binding.CommpanySwitch.isChecked) {
                val move = Intent(this, ProfitabilityIndexDifferent::class.java)
                startActivity(move)
            } else if (binding.CommpanySwitch.isChecked) {
                val move = Intent(this, ProfitabilityIndexStable::class.java)
                startActivity(move)
            } else if (binding.CashFlowSwitch.isChecked) {
                val move = Intent(this, UnderConstruction::class.java)
                startActivity(move)
            } else {
                val move = Intent(this, ProfitabilityIndexOneStable::class.java)
                startActivity(move)
            }
        }
    }

    private fun moveToNPV() {
        binding.cardViewNpv.setOnClickListener {
            if (binding.CashFlowSwitch.isChecked && binding.CommpanySwitch.isChecked) {
                val move = Intent(this, NetPresentValueDifferent::class.java)
                startActivity(move)
            } else if (binding.CommpanySwitch.isChecked) {
                val move = Intent(this, NetPresentValueStable::class.java)
                startActivity(move)
            } else if (binding.CashFlowSwitch.isChecked) {
                val move = Intent(this, UnderConstruction::class.java)
                startActivity(move)
            } else {
                val move = Intent(this, NetPresentValueOneStable::class.java)
                startActivity(move)
            }
        }
    }

    private fun moveToPP() {
        binding.cardViewPp.setOnClickListener {
            if (binding.CashFlowSwitch.isChecked && binding.CommpanySwitch.isChecked) {
                val move = Intent(this, PaybackPeriodDifferent::class.java)
                startActivity(move)
            } else if (binding.CommpanySwitch.isChecked) {
                val move = Intent(this, PaybackPeriodStable::class.java)
                startActivity(move)
            } else if (binding.CashFlowSwitch.isChecked) {
                val move = Intent(this, UnderConstruction::class.java)
                startActivity(move)
            } else {
                val move = Intent(this, PaybackPeriodOneStable::class.java)
                startActivity(move)
            }
        }
    }
}