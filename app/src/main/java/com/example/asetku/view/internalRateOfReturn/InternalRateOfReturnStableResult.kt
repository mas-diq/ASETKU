package com.example.asetku.view.internalRateOfReturn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityInternalRateOfReturnStableResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class InternalRateOfReturnStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnStableResultBinding
    private lateinit var viewModel: AccountingViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityInternalRateOfReturnStableResultBinding.inflate(layoutInflater)
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
            val commpany_1: Double = viewModel.IRRstableCount(
                extras.getString("initialInvestment_1_1")!!.toDouble(),
                extras.getString("cashFlow_1_1")!!.toDouble(),
                extras.getString("year_1_1")!!.toDouble(),
                extras.getString("discountRate_1_1")!!.toDouble(),
                extras.getString("initialInvestment_1_2")!!.toDouble(),
                extras.getString("cashFlow_1_2")!!.toDouble(),
                extras.getString("year_1_2")!!.toDouble(),
                extras.getString("discountRate_1_2")!!.toDouble()
            )
            val commpany_2: Double = viewModel.IRRstableCount(
                extras.getString("initialInvestment_2_1")!!.toDouble(),
                extras.getString("cashFlow_2_1")!!.toDouble(),
                extras.getString("year_2_1")!!.toDouble(),
                extras.getString("discountRate_2_1")!!.toDouble(),
                extras.getString("initialInvestment_2_2")!!.toDouble(),
                extras.getString("cashFlow_2_2")!!.toDouble(),
                extras.getString("year_2_2")!!.toDouble(),
                extras.getString("discountRate_2_2")!!.toDouble()

            )
            val commpany_3: Double = viewModel.IRRstableCount(
                extras.getString("initialInvestment_3_1")!!.toDouble(),
                extras.getString("cashFlow_3_1")!!.toDouble(),
                extras.getString("year_3_1")!!.toDouble(),
                extras.getString("discountRate_3_1")!!.toDouble(),
                extras.getString("initialInvestment_3_2")!!.toDouble(),
                extras.getString("cashFlow_3_2")!!.toDouble(),
                extras.getString("year_3_2")!!.toDouble(),
                extras.getString("discountRate_3_2")!!.toDouble()
            )
            val result_1 = String.format("%.3f", commpany_1).toDouble()
            val result_2 = String.format("%.3f", commpany_2).toDouble()
            val result_3 = String.format("%.3f", commpany_3).toDouble()

            if (result_1 <= extras.getString("discountRate_1_1")!!.toDouble()) {
                binding.result.tvPerusahaan1Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1Value.text =
                    "Internal Rate of Return = $result_1% (not feasible)"
            } else {
                binding.result.tvPerusahaan1Value.text =
                    "Internal Rate of Return = $result_1% (feasible)"
            }

            if (result_2 <= extras.getString("discountRate_2_1")!!.toDouble()) {
                binding.result.tvPerusahaan2Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan2Value.text =
                    "Internal Rate of Return = $result_2% (not feasible)"
            } else {
                binding.result.tvPerusahaan2Value.text =
                    "Internal Rate of Return = $result_2% (feasible)"
            }

            if (result_3 <= extras.getString("discountRate_3_1")!!.toDouble()) {
                binding.result.tvPerusahaan3Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan3Value.text =
                    "Internal Rate of Return = $result_3% (not feasible)"
            } else {
                binding.result.tvPerusahaan3Value.text =
                    "Internal Rate of Return = $result_3% (feasible)"
            }

            if (commpany_1 >= commpany_2 && commpany_1 >= commpany_3) {
                binding.recommendation.textValue.text = getString(R.string.company_1)
            } else if (commpany_2 >= commpany_3) {
                binding.recommendation.textValue.text = getString(R.string.company_2)
            } else {
                binding.recommendation.textValue.text = getString(R.string.company_3)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun changeData() {
        binding.header.textView.text = getString(R.string.stable_title)
        binding.recommendation.card.setBackgroundColor(getColor(R.color.blue))
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener {
            val move = Intent(this, InternalRateOfReturnStable::class.java)
            startActivity(move)
        }
        binding.btnBack.button.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
            finish()
        }
    }
}