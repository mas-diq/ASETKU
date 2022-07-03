package com.example.asetku.view.internalRateOfReturn

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityInternalRateOfReturnStableBinding
import com.example.asetku.view.LoadingScreen
import com.example.asetku.view.MainActivity

class InternalRateOfReturnStable : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalRateOfReturnStableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        changeData()
        count()
        back()
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
                val move = Intent(this, LoadingScreen::class.java)
                val bundleData = Bundle()
                bundleData.apply {
                    putString("dir", "irrStable")
                    // Structures ..._company_npv
                    // Company 1 NPV 1
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

                    // Company 1 NPV 2
                    putString(
                        "initialInvestment_1_2",
                        binding.input2.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_1_2", binding.input2.textField2.textEdit.text.toString())
                    putString("year_1_2", binding.input2.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_1_2",
                        binding.input2.textField4.textEdit.text.toString()
                    )

                    // Company 2 NPV 1
                    putString(
                        "initialInvestment_2_1",
                        binding.input3.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_2_1", binding.input3.textField2.textEdit.text.toString())
                    putString("year_2_1", binding.input3.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_2_1",
                        binding.input3.textField4.textEdit.text.toString()
                    )

                    // Company 2 NPV 2
                    putString(
                        "initialInvestment_2_2",
                        binding.input4.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_2_2", binding.input4.textField2.textEdit.text.toString())
                    putString("year_2_2", binding.input4.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_2_2",
                        binding.input4.textField4.textEdit.text.toString()
                    )

                    // Company 3 NPV 1
                    putString(
                        "initialInvestment_3_1",
                        binding.input5.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_3_1", binding.input5.textField2.textEdit.text.toString())
                    putString("year_3_1", binding.input5.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_3_1",
                        binding.input5.textField4.textEdit.text.toString()
                    )

                    // Company 3 NPV 2
                    putString(
                        "initialInvestment_3_2",
                        binding.input6.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_3_2", binding.input6.textField2.textEdit.text.toString())
                    putString("year_3_2", binding.input6.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_3_2",
                        binding.input6.textField4.textEdit.text.toString()
                    )
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

        // Company 1 NPV 1
        binding.input1.textViewTitle.text = getString(R.string.company_1_1)
        binding.input1.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input1.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input1.textField3.textField.hint = getString(R.string.year)
        binding.input1.textField4.textField.hint = getString(R.string.discount_rate)

        // Company 1 NPV 2
        binding.input2.textViewTitle.text = getString(R.string.company_1_2)
        binding.input2.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input2.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input2.textField3.textField.hint = getString(R.string.year)
        binding.input2.textField4.textField.hint = getString(R.string.discount_rate)

        // Company 2 NPV 1
        binding.input3.textViewTitle.text = getString(R.string.company_2_1)
        binding.input3.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input3.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input3.textField3.textField.hint = getString(R.string.year)
        binding.input3.textField4.textField.hint = getString(R.string.discount_rate)

        // Company 2 NPV 2
        binding.input4.textViewTitle.text = getString(R.string.company_2_2)
        binding.input4.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input4.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input4.textField3.textField.hint = getString(R.string.year)
        binding.input4.textField4.textField.hint = getString(R.string.discount_rate)

        // Company 3 NPV 1
        binding.input5.textViewTitle.text = getString(R.string.company_3_1)
        binding.input5.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input5.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input5.textField3.textField.hint = getString(R.string.year)
        binding.input5.textField4.textField.hint = getString(R.string.discount_rate)

        // Company 3 NPV 2
        binding.input6.textViewTitle.text = getString(R.string.company_3_2)
        binding.input6.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input6.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input6.textField3.textField.hint = getString(R.string.year)
        binding.input6.textField4.textField.hint = getString(R.string.discount_rate)
    }

    private fun checkNull(): Boolean {
        return binding.input1.textField1.textEdit.text.isNullOrBlank() ||
                binding.input1.textField2.textEdit.text.isNullOrBlank() ||
                binding.input1.textField3.textEdit.text.isNullOrBlank() ||
                binding.input1.textField4.textEdit.text.isNullOrBlank() ||
                binding.input2.textField1.textEdit.text.isNullOrBlank() ||
                binding.input2.textField2.textEdit.text.isNullOrBlank() ||
                binding.input2.textField3.textEdit.text.isNullOrBlank() ||
                binding.input2.textField4.textEdit.text.isNullOrBlank() ||
                binding.input3.textField1.textEdit.text.isNullOrBlank() ||
                binding.input3.textField2.textEdit.text.isNullOrBlank() ||
                binding.input3.textField3.textEdit.text.isNullOrBlank() ||
                binding.input3.textField4.textEdit.text.isNullOrBlank() ||
                binding.input4.textField1.textEdit.text.isNullOrBlank() ||
                binding.input4.textField2.textEdit.text.isNullOrBlank() ||
                binding.input4.textField3.textEdit.text.isNullOrBlank() ||
                binding.input4.textField4.textEdit.text.isNullOrBlank() ||
                binding.input5.textField1.textEdit.text.isNullOrBlank() ||
                binding.input5.textField2.textEdit.text.isNullOrBlank() ||
                binding.input5.textField3.textEdit.text.isNullOrBlank() ||
                binding.input5.textField4.textEdit.text.isNullOrBlank() ||
                binding.input6.textField1.textEdit.text.isNullOrBlank() ||
                binding.input6.textField2.textEdit.text.isNullOrBlank() ||
                binding.input6.textField3.textEdit.text.isNullOrBlank() ||
                binding.input6.textField4.textEdit.text.isNullOrBlank()
    }
}