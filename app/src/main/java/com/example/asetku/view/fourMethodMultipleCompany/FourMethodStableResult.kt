package com.example.asetku.view.fourMethodMultipleCompany

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.asetku.R
import com.example.asetku.databinding.ActivityFourMethodStableResultBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.viewmodel.AccountingViewModel

class FourMethodStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityFourMethodStableResultBinding
    private lateinit var viewModel: AccountingViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountingViewModel::class.java]
        binding = ActivityFourMethodStableResultBinding.inflate(layoutInflater)
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
            //get Data
            val commpany_1 = arrayOf(
                extras.getString("initialInvestment_1_1")!!.toDouble(),
                extras.getString("cashFlow_1_1")!!.toDouble(),
                extras.getString("year_1_1")!!.toDouble(),
                extras.getString("discountRate_1_1")!!.toDouble(),
                extras.getString("initialInvestment_1_2")!!.toDouble(),
                extras.getString("cashFlow_1_2")!!.toDouble(),
                extras.getString("year_1_2")!!.toDouble(),
                extras.getString("discountRate_1_2")!!.toDouble()
            )
            val commpany_2 = arrayOf(
                extras.getString("initialInvestment_2_1")!!.toDouble(),
                extras.getString("cashFlow_2_1")!!.toDouble(),
                extras.getString("year_2_1")!!.toDouble(),
                extras.getString("discountRate_2_1")!!.toDouble(),
                extras.getString("initialInvestment_2_2")!!.toDouble(),
                extras.getString("cashFlow_2_2")!!.toDouble(),
                extras.getString("year_2_2")!!.toDouble(),
                extras.getString("discountRate_2_2")!!.toDouble(),
            )
            val commpany_3 = arrayOf(
                extras.getString("initialInvestment_3_1")!!.toDouble(),
                extras.getString("cashFlow_3_1")!!.toDouble(),
                extras.getString("year_3_1")!!.toDouble(),
                extras.getString("discountRate_3_1")!!.toDouble(),
                extras.getString("initialInvestment_3_2")!!.toDouble(),
                extras.getString("cashFlow_3_2")!!.toDouble(),
                extras.getString("year_3_2")!!.toDouble(),
                extras.getString("discountRate_3_2")!!.toDouble(),
            )
            val company = arrayOf(commpany_1, commpany_2, commpany_3)

            val result_pp = DoubleArray(3)
            val result_npv = DoubleArray(3)
            val result_pi = DoubleArray(3)
            val result_irr = DoubleArray(3)

            for (i in 0..2) {
                result_pp[i] =
                    viewModel.PPstableCount(
                        company[i][0],
                        company[i][1],
                    )
                result_npv[i] =
                    viewModel.NPVstableCount(
                        company[i][0],
                        company[i][1],
                        company[i][2],
                        company[i][3]
                    )
                result_pi[i] =
                    viewModel.PIstableCount(
                        company[i][0],
                        company[i][1],
                        company[i][2],
                        company[i][3]
                    )
                result_irr[i] =
                    viewModel.IRRstableCount(
                        company[i][0],
                        company[i][1],
                        company[i][2],
                        company[i][3],
                        company[i][4],
                        company[i][5],
                        company[i][6],
                        company[i][7]
                    )
            }

            // Change format
            val result_print_pp = arrayOfNulls<String>(3)
            val result_print_npv = arrayOfNulls<String>(3)
            val result_print_pi = arrayOfNulls<String>(3)
            val result_print_irr = arrayOfNulls<String>(3)

            for (i in 0..2) {
                result_print_pp[i] = String.format("%.1f", result_pp[i])
            }
            for (i in 0..2) {
                result_print_npv[i] = String.format("%.3f", result_npv[i])
            }
            for (i in 0..2) {
                result_print_pi[i] = String.format("%.3f", result_pi[i])
            }
            for (i in 0..2) {
                result_print_irr[i] = String.format("%.3f", result_irr[i])
            }

            // Show result PP
            binding.result.tvPerusahaan1ValuePP.text = "Payback Period = ${result_print_pp[0]} Year"
            binding.result.tvPerusahaan2ValuePP.text = "Payback Period = ${result_print_pp[1]} Year"
            binding.result.tvPerusahaan3ValuePP.text = "Payback Period = ${result_print_pp[2]} Year"

            // Show result NPV
            if (result_npv[0] <= 0) {
                binding.result.tvPerusahaan1ValueNPV.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1ValueNPV.text =
                    "Net Present Value = $${result_print_npv[0]} (not feasible)"
            } else {
                binding.result.tvPerusahaan1ValueNPV.text =
                    "Net Present Value = $${result_print_npv[0]} (feasible)"
            }
            if (result_npv[1] <= 0) {
                binding.result.tvPerusahaan2ValueNPV.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan2ValueNPV.text =
                    "Net Present Value = $${result_print_npv[1]} (not feasible)"
            } else {
                binding.result.tvPerusahaan2ValueNPV.text =
                    "Net Present Value = $${result_print_npv[1]} (feasible)"
            }
            if (result_npv[2] <= 0) {
                binding.result.tvPerusahaan3ValueNPV.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan3ValueNPV.text =
                    "Net Present Value = $${result_print_npv[2]} (not feasible)"
            } else {
                binding.result.tvPerusahaan3ValueNPV.text =
                    "Net Present Value = $${result_print_npv[2]} (feasible)"
            }

            // Show result PI
            if (result_pi[0] <= 1) {
                binding.result.tvPerusahaan1ValuePI.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1ValuePI.text =
                    "Profitability Index = ${result_print_pi[0]} (not feasible)"
            } else {
                binding.result.tvPerusahaan1ValuePI.text =
                    "Profitability Index = ${result_print_pi[0]} (feasible)"
            }
            if (result_pi[1] <= 1) {
                binding.result.tvPerusahaan2ValuePI.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan2ValuePI.text =
                    "Profitability Index = ${result_print_pi[1]} (not feasible)"
            } else {
                binding.result.tvPerusahaan2ValuePI.text =
                    "Profitability Index = ${result_print_pi[1]} (feasible)"
            }
            if (result_pi[2] <= 1) {
                binding.result.tvPerusahaan3ValuePI.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan3ValuePI.text =
                    "Profitability Index = ${result_print_pi[2]} (not feasible)"
            } else {
                binding.result.tvPerusahaan3ValuePI.text =
                    "Profitability Index = ${result_print_pi[2]} (feasible)"
            }

            // Show result IRR
            if (result_pi[0] <= 0) {
                binding.result.tvPerusahaan1ValueIRR.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan1ValueIRR.text =
                    "Internal Rate of Return = ${result_print_irr[0]} (not feasible)"
            } else {
                binding.result.tvPerusahaan1ValueIRR.text =
                    "Internal Rate of Return = ${result_print_irr[0]} (feasible)"
            }

            if (result_pi[1] <= 0) {
                binding.result.tvPerusahaan2ValueIRR.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan2ValueIRR.text =
                    "Internal Rate of Return = ${result_print_irr[1]} (not feasible)"
            } else {
                binding.result.tvPerusahaan2ValueIRR.text =
                    "Internal Rate of Return = ${result_print_irr[1]} (feasible)"
            }

            if (result_pi[2] <= 0) {
                binding.result.tvPerusahaan3ValueIRR.setTextColor(getColor(R.color.red))
                binding.result.tvPerusahaan3ValueIRR.text =
                    "Internal Rate of Return = ${result_print_irr[2]} (not feasible)"
            } else {
                binding.result.tvPerusahaan3ValueIRR.text =
                    "Internal Rate of Return = ${result_print_irr[2]} (feasible)"
            }

            if (result_npv[0] >= result_npv[1] && result_npv[0] >= result_npv[2]) {
                binding.recommendation.textValue.text = getString(R.string.company_1)
            } else if (result_npv[1] >= result_npv[2]) {
                binding.recommendation.textValue.text = getString(R.string.company_2)
            } else {
                binding.recommendation.textValue.text = getString(R.string.company_3)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun changeData() {
        binding.header.textView.text = getString(R.string.stable_title)
        binding.recommendation.card.setBackgroundColor(getColor(R.color.violet))
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener {
            val move = Intent(this, FourMethodStable::class.java)
            startActivity(move)
        }
        binding.btnBack.button.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
            finish()
        }
    }
}