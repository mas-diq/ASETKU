package com.example.asetku.view.paybackPeriodMultipleCompany

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityPaybackPeriodStableResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class PaybackPeriodStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodStableResultBinding
    private lateinit var viewModel: AccountingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityPaybackPeriodStableResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        getData(intent.extras)
        changeData()
        back()
    }

    @SuppressLint("SetTextI18n")
    private fun getData(extras: Bundle?) {
        if (extras != null) {
            val commpany_1: Double = viewModel.PPstableCount(
                extras.getString("initialInvestment_1")!!.toDouble(),
                extras.getString("cashFlow_1")!!.toDouble(),

            )
            val commpany_2: Double = viewModel.PPstableCount(
                extras.getString("initialInvestment_2")!!.toDouble(),
                extras.getString("cashFlow_2")!!.toDouble(),

            )
            val commpany_3: Double = viewModel.PPstableCount(
                extras.getString("initialInvestment_3")!!.toDouble(),
                extras.getString("cashFlow_3")!!.toDouble(),
            )
            val result_1 = String.format("%.3f", commpany_1).toDouble()
            val result_2 = String.format("%.3f", commpany_2).toDouble()
            val result_3 = String.format("%.3f", commpany_3).toDouble()

            binding.result.tvPerusahaan1Value.text = "Payback Period = $result_1 Year"
            binding.result.tvPerusahaan2Value.text = "Payback Period = $result_2 Year"
            binding.result.tvPerusahaan3Value.text = "Payback Period = $result_3 Year"

            if (commpany_1 <= commpany_2 && commpany_1 <= commpany_3) {
                binding.recommendation.textValue.text = getString(R.string.company_1)
            } else if (commpany_2 <= commpany_3) {
                binding.recommendation.textValue.text = getString(R.string.company_2)
            } else {
                binding.recommendation.textValue.text = getString(R.string.company_3)
            }
        }
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener {
            val move = Intent(this, PaybackPeriodStable::class.java)
            startActivity(move)
        }
        binding.btnBack.button.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
    }

    private fun changeData() {
        binding.header.textView.text = getString(R.string.stable_title)
    }

}