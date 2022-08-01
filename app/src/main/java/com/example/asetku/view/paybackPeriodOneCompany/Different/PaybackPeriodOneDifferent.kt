package com.example.asetku.view.paybackPeriodOneCompany.Different

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityPaybackPeriodOneDifferentBinding
import com.example.asetku.view.paybackPeriodMultipleCompany.PaybackPeriodArticle

class PaybackPeriodOneDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodOneDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodOneDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getInfo()
        back()
        count()
        changeData()
    }

    private fun getInfo() {
        binding.info.setOnClickListener {
            val move = Intent(this, PaybackPeriodArticle::class.java)
            startActivity(move)
        }
    }

    private fun changeData() {
        // Header
        binding.header.textView.text = getString(R.string.different_title)

        // Perusahaan 1
        binding.input1.textViewTitle.text = getString(R.string.company)
        binding.input1.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input1.textField2.textField.hint = getString(R.string.cash_flow_1)
        binding.input1.textField3.textField.hint = getString(R.string.cash_flow_2)
        binding.input1.textField4.textField.hint = getString(R.string.cash_flow_3)
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener {
            onBackPressed()
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
                val move = Intent(this, PaybackPeriodOneDifferentResult::class.java)
                val bundleData = Bundle()
                bundleData.apply {
                    putString(
                        "initialInvestment",
                        binding.input1.textField1.textEdit.text.toString()
                    )
                    putString("cash_flow_1", binding.input1.textField2.textEdit.text.toString())
                    putString("cash_flow_2", binding.input1.textField3.textEdit.text.toString())
                    putString("cash_flow_3", binding.input1.textField4.textEdit.text.toString())
                }
                move.putExtras(bundleData)
                startActivity(move)
            }
        }
    }

    private fun checkNull(): Boolean {
        return binding.input1.textField1.textEdit.text.isNullOrBlank() ||
                binding.input1.textField2.textEdit.text.isNullOrBlank() ||
                binding.input1.textField3.textEdit.text.isNullOrBlank() ||
                binding.input1.textField4.textEdit.text.isNullOrBlank()
    }
}