package com.example.asetku.view.paybackPeriod

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityPaybackPeriodDifferentResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class PaybackPeriodDifferentResult : AppCompatActivity() {

    lateinit var binding: ActivityPaybackPeriodDifferentResultBinding
    private lateinit var viewModel: AccountingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityPaybackPeriodDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        getData(intent.extras)
        changeData()
        back()
    }

    @SuppressLint("SetTextI18n")
    private fun getData(extras: Bundle?) {
        if (extras != null) {
            val commpany_1: Double = viewModel.PPdifferentCount(
                extras?.getString("initialInvestment_1")!!.toDouble(),
                extras.getString("year_1")!!.toDouble(),
                extras.getString("cash_flow_1_1")!!.toDouble(),
                extras.getString("cash_flow_1_2")!!.toDouble(),
                extras.getString("cash_flow_1_3")!!.toDouble()

            )
            val commpany_2: Double = viewModel.PPdifferentCount(
                extras?.getString("initialInvestment_2")!!.toDouble(),
                extras.getString("year_2")!!.toDouble(),
                extras.getString("cash_flow_2_1")!!.toDouble(),
                extras.getString("cash_flow_2_2")!!.toDouble(),
                extras.getString("cash_flow_2_3")!!.toDouble()

            )
            val commpany_3: Double = viewModel.PPdifferentCount(
                extras?.getString("initialInvestment_3")!!.toDouble(),
                extras.getString("year_3")!!.toDouble(),
                extras.getString("cash_flow_3_1")!!.toDouble(),
                extras.getString("cash_flow_3_2")!!.toDouble(),
                extras.getString("cash_flow_3_3")!!.toDouble()
            )
            val result_1 = String.format("%.2f", commpany_1).toDouble()
            val result_2 = String.format("%.2f", commpany_2).toDouble()
            val result_3 = String.format("%.2f", commpany_3).toDouble()

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

    private fun changeData() {
        binding.header.textView.text = getString(R.string.different_title)
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener() {
            val move = Intent(this, PaybackPeriodDifferent::class.java)
            startActivity(move)
        }
        binding.btnBack.button.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
    }
}