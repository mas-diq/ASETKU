package com.example.asetku.view.paybackPeriodOneCompany.Different

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityPaybackPeriodOneDifferentResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class PaybackPeriodOneDifferentResult : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodOneDifferentResultBinding
    private lateinit var viewModel: AccountingViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityPaybackPeriodOneDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData(intent.extras)
        changeData()
        back()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    private fun getData(extras: Bundle?) {
        if (extras != null) {
            val company: Double = viewModel.PPdifferentCount(
                extras.getString("initialInvestment")!!.toDouble(),
                extras.getString("cash_flow_1")!!.toDouble(),
                extras.getString("cash_flow_2")!!.toDouble(),
                extras.getString("cash_flow_3")!!.toDouble()
            )
            val result = String.format("%.3f", company).toDouble()
            if (result <= 0) {
                binding.result.tvPerusahaan1Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1Value.text =
                    "Investment has not returned"
            } else {
                binding.result.tvPerusahaan1Value.text = "Payback Period = $result Years"
            }
        }
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener {
            onBackPressed()
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