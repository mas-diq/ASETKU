package com.example.asetku.view.paybackPeriodOneCompany.Stable

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityPaybackPeriodOneStableResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.view.paybackPeriodMultipleCompany.PaybackPeriodStable
import com.example.asetku.viewmodel.AccountingViewModel

class PaybackPeriodOneStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodOneStableResultBinding
    private lateinit var viewModel: AccountingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityPaybackPeriodOneStableResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData(intent.extras)
        changeData()
        back()
    }

    @SuppressLint("SetTextI18n")
    private fun getData(extras: Bundle?) {
        if (extras != null) {
            val commpany: Double = viewModel.PPstableCount(
                extras.getString("initialInvestment")!!.toDouble(),
                extras.getString("cashFlow")!!.toDouble(),
            )
            val result = String.format("%.3f", commpany).toDouble()
            binding.result.tvPerusahaan1Value.text = "Payback Period = $result Year"
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