package com.example.asetku.view.fourMethod

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityFourMethodStableBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.view.UnderConstruction

class FourMethodStable : AppCompatActivity() {

    private lateinit var binding: ActivityFourMethodStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourMethodStableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        getInfo()
        changeData()
        count()
        back()
    }

    private fun getInfo() {
        binding.info.setOnClickListener {
            val move = Intent(this, UnderConstruction::class.java)
            startActivity(move)
        }
    }

    private fun count() {
        binding.btnHitung.button.setOnClickListener {
            if (checkNull()) {
                Toast.makeText(
                    applicationContext,
                    "All value need to be filled!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val move = Intent(this, FourMethodStableResult::class.java)
                val bundleData = Bundle()
                bundleData.apply {
                    // Company 1
                    putString(
                        "initialInvestment_1_1",
                        binding.input1.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_1_1", binding.input1.textField2.textEdit.text.toString())
                    putString("year_1_1", binding.input1.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_1_1",
                        binding.input1.textField4.textEdit.text.toString()
                    )
                    putString(
                        "initialInvestment_1_2",
                        binding.input1.textField5.textEdit.text.toString()
                    )
                    putString("cashFlow_1_2", binding.input1.textField6.textEdit.text.toString())
                    putString("year_1_2", binding.input1.textField7.textEdit.text.toString())
                    putString(
                        "discountRate_1_2",
                        binding.input1.textField8.textEdit.text.toString()
                    )

                    // Company 2
                    putString(
                        "initialInvestment_2_1",
                        binding.input2.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_2_1", binding.input2.textField2.textEdit.text.toString())
                    putString("year_2_1", binding.input2.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_2_1",
                        binding.input2.textField4.textEdit.text.toString()
                    )
                    putString(
                        "initialInvestment_2_2",
                        binding.input2.textField5.textEdit.text.toString()
                    )
                    putString("cashFlow_2_2", binding.input2.textField6.textEdit.text.toString())
                    putString("year_2_2", binding.input2.textField7.textEdit.text.toString())
                    putString(
                        "discountRate_2_2",
                        binding.input2.textField8.textEdit.text.toString()
                    )

                    // Company 3
                    putString(
                        "initialInvestment_3_1",
                        binding.input3.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_3_1", binding.input3.textField2.textEdit.text.toString())
                    putString("year_3_1", binding.input3.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_3_1",
                        binding.input3.textField4.textEdit.text.toString()
                    )
                    putString(
                        "initialInvestment_3_2",
                        binding.input3.textField5.textEdit.text.toString()
                    )
                    putString("cashFlow_3_2", binding.input3.textField6.textEdit.text.toString())
                    putString("year_3_2", binding.input3.textField7.textEdit.text.toString())
                    putString(
                        "discountRate_3_2",
                        binding.input3.textField8.textEdit.text.toString()
                    )
                    putString("dir", "npvStable")
                }
                move.putExtras(bundleData)
                startActivity(move)
            }
        }
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
    }

    private fun changeData() {
        // Header
        binding.header.textView.text = getString(R.string.stable_title)

        // Perusahaan 1
        binding.input2.textViewTitle.text = getString(R.string.company_1)
        binding.input1.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input1.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input1.textField3.textField.hint = getString(R.string.year)
        binding.input1.textField4.textField.hint = getString(R.string.discount_rate)
        binding.input1.textField5.textField.hint = getString(R.string.initial_investment)
        binding.input1.textField6.textField.hint = getString(R.string.cash_flow)
        binding.input1.textField7.textField.hint = getString(R.string.year)
        binding.input1.textField8.textField.hint = getString(R.string.discount_rate)

        // Perusahaan 2
        binding.input2.textViewTitle.text = getString(R.string.company_2)
        binding.input2.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input2.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input2.textField3.textField.hint = getString(R.string.year)
        binding.input2.textField4.textField.hint = getString(R.string.discount_rate)
        binding.input2.textField5.textField.hint = getString(R.string.initial_investment)
        binding.input2.textField6.textField.hint = getString(R.string.cash_flow)
        binding.input2.textField7.textField.hint = getString(R.string.year)
        binding.input2.textField8.textField.hint = getString(R.string.discount_rate)

        // Perusahaan 3
        binding.input3.textViewTitle.text = getString(R.string.company_3)
        binding.input3.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input3.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input3.textField3.textField.hint = getString(R.string.year)
        binding.input3.textField4.textField.hint = getString(R.string.discount_rate)
        binding.input3.textField5.textField.hint = getString(R.string.initial_investment)
        binding.input3.textField6.textField.hint = getString(R.string.cash_flow)
        binding.input3.textField7.textField.hint = getString(R.string.year)
        binding.input3.textField8.textField.hint = getString(R.string.discount_rate)
    }

    private fun checkNull(): Boolean {
        return binding.input1.textField1.textEdit.text.isNullOrBlank() ||
                binding.input1.textField2.textEdit.text.isNullOrBlank() ||
                binding.input1.textField3.textEdit.text.isNullOrBlank() ||
                binding.input1.textField4.textEdit.text.isNullOrBlank() ||
                binding.input1.textField5.textEdit.text.isNullOrBlank() ||
                binding.input1.textField6.textEdit.text.isNullOrBlank() ||
                binding.input1.textField7.textEdit.text.isNullOrBlank() ||
                binding.input1.textField8.textEdit.text.isNullOrBlank() ||
                binding.input2.textField1.textEdit.text.isNullOrBlank() ||
                binding.input2.textField2.textEdit.text.isNullOrBlank() ||
                binding.input2.textField3.textEdit.text.isNullOrBlank() ||
                binding.input2.textField4.textEdit.text.isNullOrBlank() ||
                binding.input2.textField5.textEdit.text.isNullOrBlank() ||
                binding.input2.textField6.textEdit.text.isNullOrBlank() ||
                binding.input2.textField7.textEdit.text.isNullOrBlank() ||
                binding.input2.textField8.textEdit.text.isNullOrBlank() ||
                binding.input3.textField1.textEdit.text.isNullOrBlank() ||
                binding.input3.textField2.textEdit.text.isNullOrBlank() ||
                binding.input3.textField3.textEdit.text.isNullOrBlank() ||
                binding.input3.textField4.textEdit.text.isNullOrBlank() ||
                binding.input3.textField5.textEdit.text.isNullOrBlank() ||
                binding.input3.textField6.textEdit.text.isNullOrBlank() ||
                binding.input3.textField7.textEdit.text.isNullOrBlank() ||
                binding.input3.textField8.textEdit.text.isNullOrBlank()
    }
}