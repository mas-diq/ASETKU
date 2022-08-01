package com.example.asetku.view.profitabilityIndexOneCompany.Different

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityProfitabilityIndexOneDifferentResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class ProfitabilityIndexOneDifferentResult : AppCompatActivity() {

    lateinit var binding: ActivityProfitabilityIndexOneDifferentResultBinding
    private lateinit var viewModel: AccountingViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityProfitabilityIndexOneDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData(intent.extras)
        changeData()
        back()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    private fun getData(extras: Bundle?) {
        if (extras != null) {
            val commpany: Double = viewModel.PIdifferentCount(
                extras.getString("initialInvestment")!!.toDouble(),
                extras.getString("discountRate")!!.toDouble(),
                extras.getString("cash_flow_1")!!.toDouble(),
                extras.getString("cash_flow_2")!!.toDouble(),
                extras.getString("cash_flow_3")!!.toDouble()
            )
            val result = String.format("%.3f", commpany).toDouble()
            if (result <= 1) {
                binding.result.tvPerusahaan1Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1Value.text =
                    "Profitability Index = $$result (not feasible)"
            } else {
                binding.result.tvPerusahaan1Value.text =
                    "Profitability Index = $$result (feasible)"
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun changeData() {
        binding.header.textView.text = getString(R.string.stable_title)
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