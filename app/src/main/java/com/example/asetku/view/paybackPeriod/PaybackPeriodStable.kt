package com.example.asetku.view.paybackPeriod

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityPaybackPeriodStableBinding
import com.example.asetku.view.LoadingScreen
import com.example.asetku.view.MainActivity

class PaybackPeriodStable : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodStableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        changeData()
        count()
        back()
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
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
                val move = Intent(this, PaybackPeriodStableResult::class.java)
                val bundleData = Bundle()
                bundleData.apply {
                    putString(
                        "initialInvestment_1",
                        binding.input1.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_1", binding.input1.textField2.textEdit.text.toString())
                    putString("year_1", binding.input1.textField3.textEdit.text.toString())

                    putString(
                        "initialInvestment_2",
                        binding.input2.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_2", binding.input2.textField2.textEdit.text.toString())
                    putString("year_2", binding.input2.textField3.textEdit.text.toString())

                    putString(
                        "initialInvestment_3",
                        binding.input3.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_3", binding.input3.textField2.textEdit.text.toString())
                    putString("year_3", binding.input3.textField3.textEdit.text.toString())
                    putString("dir", "ppStable")
                }
                move.putExtras(bundleData)
                startActivity(move)
            }
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

        // Perusahaan 2
        binding.input2.textViewTitle.text = getString(R.string.company_2)
        binding.input2.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input2.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input2.textField3.textField.hint = getString(R.string.year)

        // Perusahaan 3
        binding.input3.textViewTitle.text = getString(R.string.company_3)
        binding.input3.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input3.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input3.textField3.textField.hint = getString(R.string.year)
    }

    private fun checkNull(): Boolean {
        return binding.input1.textField1.textEdit.text.isNullOrBlank() ||
                binding.input1.textField2.textEdit.text.isNullOrBlank() ||
                binding.input1.textField3.textEdit.text.isNullOrBlank() ||
                binding.input2.textField1.textEdit.text.isNullOrBlank() ||
                binding.input2.textField2.textEdit.text.isNullOrBlank() ||
                binding.input2.textField3.textEdit.text.isNullOrBlank() ||
                binding.input3.textField1.textEdit.text.isNullOrBlank() ||
                binding.input3.textField2.textEdit.text.isNullOrBlank() ||
                binding.input3.textField3.textEdit.text.isNullOrBlank()
    }
}