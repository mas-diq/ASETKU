package com.example.asetku.view.netPresentValueOneCompany.Different

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityNetPresentValueOneDifferentResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class NetPresentValueOneDifferentResult : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueOneDifferentResultBinding
    private lateinit var viewModel: AccountingViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityNetPresentValueOneDifferentResultBinding.inflate(layoutInflater)
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
            val company: Double = viewModel.NPVdifferentCount(
                extras.getString("initialInvestment")!!.toDouble(),
                extras.getString("discountRate")!!.toDouble(),
                extras.getString("cash_flow_1")!!.toDouble(),
                extras.getString("cash_flow_2")!!.toDouble(),
                extras.getString("cash_flow_3")!!.toDouble()
            )
            val result = String.format("%.3f", company).toDouble()
            if (result <= 0) {
                binding.result.tvPerusahaan1Value.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1Value.text =
                    "Net Present Value = $$result (not feasible)"
            } else {
                binding.result.tvPerusahaan1Value.text = "Net Present Value = $$result (feasible)"
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