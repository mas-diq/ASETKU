package com.example.asetku.view.profitabilityIndexMultipleCompany

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityProfitabilityIndexMainDifferentBinding
import com.example.asetku.view.MainActivity

class ProfitabilityIndexDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityProfitabilityIndexMainDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfitabilityIndexMainDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        getInfo()
        back()
        count()
        changeData()
    }

    private fun getInfo() {
        binding.info.setOnClickListener {
            val move = Intent(this, ProfitabilityIndexArticle::class.java)
            startActivity(move)
        }
    }

    private fun changeData() {
        // Header
        binding.header.textView.text = getString(R.string.different_title)

        // Perusahaan 1
        binding.input2.textViewTitle.text = getString(R.string.company_1)
        binding.input1.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input1.textField2.textField.hint = getString(R.string.discount_rate)
        binding.input1.textField3.textField.hint = getString(R.string.cash_flow_1)
        binding.input1.textField4.textField.hint = getString(R.string.cash_flow_2)
        binding.input1.textField5.textField.hint = getString(R.string.cash_flow_3)

        // Perusahaan 2
        binding.input2.textViewTitle.text = getString(R.string.company_2)
        binding.input2.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input2.textField2.textField.hint = getString(R.string.discount_rate)
        binding.input2.textField3.textField.hint = getString(R.string.cash_flow_1)
        binding.input2.textField4.textField.hint = getString(R.string.cash_flow_2)
        binding.input2.textField5.textField.hint = getString(R.string.cash_flow_3)

        // Perusahaan 3
        binding.input3.textViewTitle.text = getString(R.string.company_3)
        binding.input3.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input3.textField2.textField.hint = getString(R.string.discount_rate)
        binding.input3.textField3.textField.hint = getString(R.string.cash_flow_1)
        binding.input3.textField4.textField.hint = getString(R.string.cash_flow_2)
        binding.input3.textField5.textField.hint = getString(R.string.cash_flow_3)
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
                val move = Intent(this, ProfitabilityIndexDifferentResult::class.java)
                val bundleData = Bundle()
                bundleData.apply {
                    putString(
                        "initialInvestment_1",
                        binding.input1.textField1.textEdit.text.toString()
                    )
                    putString("discountRate_1", binding.input1.textField2.textEdit.text.toString())
                    putString("cash_flow_1_1", binding.input1.textField3.textEdit.text.toString())
                    putString("cash_flow_1_2", binding.input1.textField4.textEdit.text.toString())
                    putString("cash_flow_1_3", binding.input1.textField5.textEdit.text.toString())

                    putString(
                        "initialInvestment_2",
                        binding.input2.textField1.textEdit.text.toString()
                    )
                    putString("discountRate_2", binding.input2.textField2.textEdit.text.toString())
                    putString("cash_flow_2_1", binding.input2.textField3.textEdit.text.toString())
                    putString("cash_flow_2_2", binding.input2.textField4.textEdit.text.toString())
                    putString("cash_flow_2_3", binding.input2.textField5.textEdit.text.toString())

                    putString(
                        "initialInvestment_3",
                        binding.input3.textField1.textEdit.text.toString()
                    )
                    putString("discountRate_3", binding.input3.textField2.textEdit.text.toString())
                    putString("cash_flow_3_1", binding.input3.textField3.textEdit.text.toString())
                    putString("cash_flow_3_2", binding.input3.textField4.textEdit.text.toString())
                    putString("cash_flow_3_3", binding.input3.textField5.textEdit.text.toString())
                    putString("dir", "piDifferent")
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
                binding.input1.textField4.textEdit.text.isNullOrBlank() ||
                binding.input1.textField5.textEdit.text.isNullOrBlank() ||
                binding.input2.textField1.textEdit.text.isNullOrBlank() ||
                binding.input2.textField2.textEdit.text.isNullOrBlank() ||
                binding.input2.textField3.textEdit.text.isNullOrBlank() ||
                binding.input2.textField4.textEdit.text.isNullOrBlank() ||
                binding.input2.textField5.textEdit.text.isNullOrBlank() ||
                binding.input3.textField1.textEdit.text.isNullOrBlank() ||
                binding.input3.textField2.textEdit.text.isNullOrBlank() ||
                binding.input3.textField3.textEdit.text.isNullOrBlank() ||
                binding.input3.textField4.textEdit.text.isNullOrBlank() ||
                binding.input3.textField5.textEdit.text.isNullOrBlank()
    }
}