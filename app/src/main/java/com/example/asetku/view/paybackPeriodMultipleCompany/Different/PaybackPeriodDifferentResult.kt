package com.example.asetku.view.paybackPeriodMultipleCompany.Different

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityPaybackPeriodDifferentResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class PaybackPeriodDifferentResult : AppCompatActivity() {

    lateinit var binding: ActivityPaybackPeriodDifferentResultBinding
    private lateinit var viewModel: AccountingViewModel

    @RequiresApi(Build.VERSION_CODES.M)
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

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    private fun getData(extras: Bundle?) {
        if (extras != null) {
            val company1: Double = viewModel.PPdifferentCount(
                extras.getString("initialInvestment_1")!!.toDouble(),
                extras.getString("cash_flow_1_1")!!.toDouble(),
                extras.getString("cash_flow_1_2")!!.toDouble(),
                extras.getString("cash_flow_1_3")!!.toDouble()

            )
            val company2: Double = viewModel.PPdifferentCount(
                extras.getString("initialInvestment_2")!!.toDouble(),
                extras.getString("cash_flow_2_1")!!.toDouble(),
                extras.getString("cash_flow_2_2")!!.toDouble(),
                extras.getString("cash_flow_2_3")!!.toDouble()

            )
            val company3: Double = viewModel.PPdifferentCount(
                extras.getString("initialInvestment_3")!!.toDouble(),
                extras.getString("cash_flow_3_1")!!.toDouble(),
                extras.getString("cash_flow_3_2")!!.toDouble(),
                extras.getString("cash_flow_3_3")!!.toDouble()
            )
            val result_1 = String.format("%.3f", company1).toDouble()
            val result_2 = String.format("%.3f", company2).toDouble()
            val result_3 = String.format("%.3f", company3).toDouble()

            if (result_1 <= 0) {
                binding.result.tvPerusahaan1Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1Value.text =
                    "Investment has not returned"
            } else {
                binding.result.tvPerusahaan1Value.text = "Payback Period = $result_1 Years"
            }

            if (result_2 <= 0) {
                binding.result.tvPerusahaan2Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan2Value.text =
                    "Investment has not returned"
            } else {
                binding.result.tvPerusahaan2Value.text = "Payback Period = $result_2 Years"
            }

            if (result_3 <= 0) {
                binding.result.tvPerusahaan3Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan3Value.text =
                    "Investment has not returned"
            } else {
                binding.result.tvPerusahaan3Value.text = "Payback Period = $result_3 Years"
            }

            if (company1 <= company2 && company1 <= company3) {
                binding.recommendation.textValue.text = getString(R.string.company_1)
            } else if (company2 <= company3) {
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
        binding.header.iconBack.setOnClickListener {
            onBackPressed()
        }
        binding.btnBack.button.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
            finish()
        }
    }
}