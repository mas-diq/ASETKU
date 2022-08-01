package com.example.asetku.view.internalRateOfReturnOneCompany.Different

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityInternalRateOfReturnOneDifferentResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class InternalRateOfReturnOneDifferentResult : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnOneDifferentResultBinding
    private lateinit var viewModel: AccountingViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityInternalRateOfReturnOneDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData(intent.extras)
        changeData()
        back()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    private fun getData(extras: Bundle?) {
        if (extras != null) {
            val company: Double = viewModel.IRRdifferentCount(
                extras.getString("initialInvestment_1")!!.toDouble(),
                extras.getString("discountRate_1")!!.toDouble(),
                extras.getString("cashFlow_1_1")!!.toDouble(),
                extras.getString("cashFlow_1_2")!!.toDouble(),
                extras.getString("cashFlow_1_3")!!.toDouble(),
                extras.getString("initialInvestment_2")!!.toDouble(),
                extras.getString("discountRate_2")!!.toDouble(),
                extras.getString("cashFlow_2_1")!!.toDouble(),
                extras.getString("cashFlow_2_2")!!.toDouble(),
                extras.getString("cashFlow_2_3")!!.toDouble()
            )
            val result = String.format("%.3f", company).toDouble()
            if (result <= extras.getString("discountRate_1")!!.toDouble()) {
                binding.result.tvPerusahaan1Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1Value.text =
                    "Internal Rate of Return = $result (not feasible)"
            } else {
                binding.result.tvPerusahaan1Value.text =
                    "Internal Rate of Return = $result (feasible)"
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
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