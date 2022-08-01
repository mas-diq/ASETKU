package com.example.asetku.view.netPresentValueOneCompany.Stable

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityNetPresentValueOneStableResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.view.netPresentValueMultipleCompany.NetPresentValueStable
import com.example.asetku.viewmodel.AccountingViewModel

class NetPresentValueOneStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueOneStableResultBinding
    private lateinit var viewModel: AccountingViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityNetPresentValueOneStableResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData(intent.extras)
        changeData()
        back()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    private fun getData(extras: Bundle?) {
        if (extras != null) {
            val commpany: Double = viewModel.NPVstableCount(
                extras.getString("initialInvestment")!!.toDouble(),
                extras.getString("cashFlow")!!.toDouble(),
                extras.getString("year")!!.toDouble(),
                extras.getString("discountRate")!!.toDouble()
            )
            val result = String.format("%.3f", commpany).toDouble()
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
            val move = Intent(this, NetPresentValueStable::class.java)
            startActivity(move)
        }
        binding.btnBack.button.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
            finish()
        }
    }
}