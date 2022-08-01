package com.example.asetku.view.internalRateOfReturnOneCompany.Stable

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityInternalRateOfReturnOneStableResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class InternalRateOfReturnOneStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnOneStableResultBinding
    private lateinit var viewModel: AccountingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityInternalRateOfReturnOneStableResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData(intent.extras)
        changeData()
        back()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    private fun getData(extras: Bundle?) {
        if (extras != null) {
            val commpany: Double = viewModel.IRRstableCount(
                extras.getString("initialInvestment_1")!!.toDouble(),
                extras.getString("cashFlow_1")!!.toDouble(),
                extras.getString("year_1")!!.toDouble(),
                extras.getString("discountRate_1")!!.toDouble(),
                extras.getString("initialInvestment_2")!!.toDouble(),
                extras.getString("cashFlow_2")!!.toDouble(),
                extras.getString("year_2")!!.toDouble(),
                extras.getString("discountRate_2")!!.toDouble()
            )
            val result = String.format("%.3f", commpany).toDouble()
            if (result <= extras.getString("discountRate_1")!!.toDouble()) {
                binding.result.tvPerusahaan1Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1Value.text =
                    "Internal Rate of Return = $result% (not feasible)"
            } else {
                binding.result.tvPerusahaan1Value.text =
                    "Internal Rate of Return = $result% (feasible)"
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