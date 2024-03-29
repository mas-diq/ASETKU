package com.example.asetku.view.internalRateOfReturnMultipleCompany.Different

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityInternalRateOfReturnDifferentBinding
import com.example.asetku.view.UnderConstruction

class InternalRateOfReturnDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalRateOfReturnDifferentBinding.inflate(layoutInflater)
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
                val move = Intent(this, InternalRateOfReturnDifferentResult::class.java)
                val bundleData = Bundle()
                bundleData.apply {
                    // Structures ..._company_npv
                    // Company 1 NPV 1
                    putString(
                        "initialInvestment_1_1",
                        binding.input1.textField1.textEdit.text.toString()
                    )
                    putString(
                        "discountRate_1_1",
                        binding.input1.textField2.textEdit.text.toString()
                    )
                    putString("cashFlow_1_1_1", binding.input1.textField3.textEdit.text.toString())
                    putString("cashFlow_1_1_2", binding.input1.textField4.textEdit.text.toString())
                    putString("cashFlow_1_1_3", binding.input1.textField5.textEdit.text.toString())


                    // Company 1 NPV 2
                    putString(
                        "initialInvestment_1_2",
                        binding.input2.textField1.textEdit.text.toString()
                    )
                    putString(
                        "discountRate_1_2",
                        binding.input2.textField2.textEdit.text.toString()
                    )
                    putString("cashFlow_1_2_1", binding.input2.textField3.textEdit.text.toString())
                    putString("cashFlow_1_2_2", binding.input2.textField4.textEdit.text.toString())
                    putString("cashFlow_1_2_3", binding.input2.textField5.textEdit.text.toString())

                    // Company 2 NPV 1
                    putString(
                        "initialInvestment_2_1",
                        binding.input3.textField1.textEdit.text.toString()
                    )
                    putString(
                        "discountRate_2_1",
                        binding.input3.textField2.textEdit.text.toString()
                    )
                    putString("cashFlow_2_1_1", binding.input3.textField3.textEdit.text.toString())
                    putString("cashFlow_2_1_2", binding.input3.textField4.textEdit.text.toString())
                    putString("cashFlow_2_1_3", binding.input3.textField5.textEdit.text.toString())

                    // Company 2 NPV 2
                    putString(
                        "initialInvestment_2_2",
                        binding.input4.textField1.textEdit.text.toString()
                    )
                    putString(
                        "discountRate_2_2",
                        binding.input4.textField2.textEdit.text.toString()
                    )
                    putString("cashFlow_2_2_1", binding.input4.textField3.textEdit.text.toString())
                    putString("cashFlow_2_2_2", binding.input4.textField4.textEdit.text.toString())
                    putString("cashFlow_2_2_3", binding.input4.textField5.textEdit.text.toString())

                    // Company 3 NPV 1
                    putString(
                        "initialInvestment_3_1",
                        binding.input5.textField1.textEdit.text.toString()
                    )
                    putString(
                        "discountRate_3_1",
                        binding.input5.textField2.textEdit.text.toString()
                    )
                    putString("cashFlow_3_1_1", binding.input5.textField3.textEdit.text.toString())
                    putString("cashFlow_3_1_2", binding.input5.textField4.textEdit.text.toString())
                    putString("cashFlow_3_1_3", binding.input5.textField5.textEdit.text.toString())

                    // Company 3 NPV 2
                    putString(
                        "initialInvestment_3_2",
                        binding.input6.textField1.textEdit.text.toString()
                    )
                    putString(
                        "discountRate_3_2",
                        binding.input6.textField2.textEdit.text.toString()
                    )
                    putString("cashFlow_3_2_1", binding.input6.textField3.textEdit.text.toString())
                    putString("cashFlow_3_2_2", binding.input6.textField4.textEdit.text.toString())
                    putString("cashFlow_3_2_3", binding.input6.textField5.textEdit.text.toString())
                    putString("dir", "irrDifferent")
                }
                move.putExtras(bundleData)
                startActivity(move)
            }
        }
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun changeData() {
        // Header
        binding.header.textView.text = getString(R.string.stable_title)

        // Company 1 NPV 1
        binding.input1.textViewTitle.text = getString(R.string.company_1_1)
        binding.input1.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input1.textField2.textField.hint = getString(R.string.discount_rate)
        binding.input1.textField3.textField.hint = getString(R.string.cash_flow_1)
        binding.input1.textField4.textField.hint = getString(R.string.cash_flow_2)
        binding.input1.textField5.textField.hint = getString(R.string.cash_flow_2)

        // Company 1 NPV 2
        binding.input2.textViewTitle.text = getString(R.string.company_1_2)
        binding.input2.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input2.textField2.textField.hint = getString(R.string.discount_rate)
        binding.input2.textField3.textField.hint = getString(R.string.cash_flow_1)
        binding.input2.textField4.textField.hint = getString(R.string.cash_flow_2)
        binding.input2.textField5.textField.hint = getString(R.string.cash_flow_2)

        // Company 2 NPV 1
        binding.input3.textViewTitle.text = getString(R.string.company_2_1)
        binding.input3.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input3.textField2.textField.hint = getString(R.string.discount_rate)
        binding.input3.textField3.textField.hint = getString(R.string.cash_flow_1)
        binding.input3.textField4.textField.hint = getString(R.string.cash_flow_2)
        binding.input3.textField5.textField.hint = getString(R.string.cash_flow_2)

        // Company 2 NPV 2
        binding.input4.textViewTitle.text = getString(R.string.company_2_2)
        binding.input4.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input4.textField2.textField.hint = getString(R.string.discount_rate)
        binding.input4.textField3.textField.hint = getString(R.string.cash_flow_1)
        binding.input4.textField4.textField.hint = getString(R.string.cash_flow_2)
        binding.input4.textField5.textField.hint = getString(R.string.cash_flow_2)

        // Company 3 NPV 1
        binding.input5.textViewTitle.text = getString(R.string.company_3_1)
        binding.input5.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input5.textField2.textField.hint = getString(R.string.discount_rate)
        binding.input5.textField3.textField.hint = getString(R.string.cash_flow_1)
        binding.input5.textField4.textField.hint = getString(R.string.cash_flow_2)
        binding.input5.textField5.textField.hint = getString(R.string.cash_flow_2)

        // Company 3 NPV 2
        binding.input6.textViewTitle.text = getString(R.string.company_3_2)
        binding.input6.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input6.textField2.textField.hint = getString(R.string.discount_rate)
        binding.input6.textField3.textField.hint = getString(R.string.cash_flow_1)
        binding.input6.textField4.textField.hint = getString(R.string.cash_flow_2)
        binding.input6.textField5.textField.hint = getString(R.string.cash_flow_2)
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
                binding.input3.textField5.textEdit.text.isNullOrBlank() ||
                binding.input4.textField1.textEdit.text.isNullOrBlank() ||
                binding.input4.textField2.textEdit.text.isNullOrBlank() ||
                binding.input4.textField3.textEdit.text.isNullOrBlank() ||
                binding.input4.textField4.textEdit.text.isNullOrBlank() ||
                binding.input4.textField5.textEdit.text.isNullOrBlank() ||
                binding.input5.textField1.textEdit.text.isNullOrBlank() ||
                binding.input5.textField2.textEdit.text.isNullOrBlank() ||
                binding.input5.textField3.textEdit.text.isNullOrBlank() ||
                binding.input5.textField4.textEdit.text.isNullOrBlank() ||
                binding.input5.textField5.textEdit.text.isNullOrBlank() ||
                binding.input6.textField1.textEdit.text.isNullOrBlank() ||
                binding.input6.textField2.textEdit.text.isNullOrBlank() ||
                binding.input6.textField3.textEdit.text.isNullOrBlank() ||
                binding.input6.textField4.textEdit.text.isNullOrBlank() ||
                binding.input6.textField5.textEdit.text.isNullOrBlank()
    }
}