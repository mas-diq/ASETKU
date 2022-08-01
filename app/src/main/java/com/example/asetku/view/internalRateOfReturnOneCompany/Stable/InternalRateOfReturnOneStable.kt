package com.example.asetku.view.internalRateOfReturnOneCompany.Stable

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityInternalRateOfReturnOneStableBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.view.UnderConstruction

class InternalRateOfReturnOneStable : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnOneStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalRateOfReturnOneStableBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                val move = Intent(this, InternalRateOfReturnOneStableResult::class.java)
                val bundleData = Bundle()
                bundleData.apply {
                    // Company 1 NPV 1
                    putString(
                        "initialInvestment_1",
                        binding.input1.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_1", binding.input1.textField2.textEdit.text.toString())
                    putString("year_1", binding.input1.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_1",
                        binding.input1.textField4.textEdit.text.toString()
                    )

                    // Company 1 NPV 2
                    putString(
                        "initialInvestment_2",
                        binding.input2.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow_2", binding.input2.textField2.textEdit.text.toString())
                    putString("year_2", binding.input2.textField3.textEdit.text.toString())
                    putString(
                        "discountRate_2",
                        binding.input2.textField4.textEdit.text.toString()
                    )
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
        binding.input1.textViewTitle.text = getString(R.string.company_0_1)
        binding.input1.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input1.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input1.textField3.textField.hint = getString(R.string.year)
        binding.input1.textField4.textField.hint = getString(R.string.discount_rate)

        // Company 1 NPV 2
        binding.input2.textViewTitle.text = getString(R.string.company_0_2)
        binding.input2.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input2.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input2.textField3.textField.hint = getString(R.string.year)
        binding.input2.textField4.textField.hint = getString(R.string.discount_rate)
    }

    private fun checkNull(): Boolean {
        return binding.input1.textField1.textEdit.text.isNullOrBlank() ||
                binding.input1.textField2.textEdit.text.isNullOrBlank() ||
                binding.input1.textField3.textEdit.text.isNullOrBlank() ||
                binding.input1.textField4.textEdit.text.isNullOrBlank() ||
                binding.input2.textField1.textEdit.text.isNullOrBlank() ||
                binding.input2.textField2.textEdit.text.isNullOrBlank() ||
                binding.input2.textField3.textEdit.text.isNullOrBlank() ||
                binding.input2.textField4.textEdit.text.isNullOrBlank()
    }
}