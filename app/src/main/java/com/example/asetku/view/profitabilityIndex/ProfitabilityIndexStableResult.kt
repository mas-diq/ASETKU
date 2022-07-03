package com.example.asetku.view.profitabilityIndex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityProfitabilityIndexStableResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class ProfitabilityIndexStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityProfitabilityIndexStableResultBinding
    private lateinit var viewModel: AccountingViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityProfitabilityIndexStableResultBinding.inflate(layoutInflater)
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
            val commpany_1: Double = viewModel.PIstableCount(
                extras?.getString("initialInvestment_1")!!.toDouble(),
                extras.getString("cashFlow_1")!!.toDouble(),
                extras.getString("year_1")!!.toDouble(),
                extras.getString("discountRate_1")!!.toDouble()

            )
            val commpany_2: Double = viewModel.PIstableCount(
                extras?.getString("initialInvestment_2")!!.toDouble(),
                extras.getString("cashFlow_2")!!.toDouble(),
                extras.getString("year_2")!!.toDouble(),
                extras.getString("discountRate_2")!!.toDouble()

            )
            val commpany_3: Double = viewModel.PIstableCount(
                extras?.getString("initialInvestment_3")!!.toDouble(),
                extras.getString("cashFlow_3")!!.toDouble(),
                extras.getString("year_3")!!.toDouble(),
                extras.getString("discountRate_3")!!.toDouble()
            )
            val result_1 = String.format("%.3f", commpany_1).toDouble()
            val result_2 = String.format("%.3f", commpany_2).toDouble()
            val result_3 = String.format("%.3f", commpany_3).toDouble()

            if (result_1 <= 0) {
                binding.result.tvPerusahaan1Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1Value.text =
                    "Profitability Index = $result_1 (not feasible)"
            } else {
                binding.result.tvPerusahaan1Value.text =
                    "Profitability Index = $result_1 (feasible)"
            }

            if (result_2 <= 0) {
                binding.result.tvPerusahaan2Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan2Value.text =
                    "Profitability Index = $result_2 (not feasible)"
            } else {
                binding.result.tvPerusahaan2Value.text =
                    "Profitability Index = $result_2 (feasible)"
            }

            if (result_3 <= 0) {
                binding.result.tvPerusahaan3Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan3Value.text =
                    "Profitability Index = $result_3 (not feasible)"
            } else {
                binding.result.tvPerusahaan3Value.text =
                    "Profitability Index = $result_3 (feasible)"
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
        binding.recommendation.card.setBackgroundColor(getColor(R.color.yellow))
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener() {
            val move = Intent(this, ProfitabilityIndexStable::class.java)
            startActivity(move)
        }
        binding.btnBack.button.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
    }
}