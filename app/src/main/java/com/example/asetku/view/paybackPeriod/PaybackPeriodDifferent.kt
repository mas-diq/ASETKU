package com.example.asetku.view.paybackPeriod

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityPaybackPeriodDifferentBinding
import com.example.asetku.view.MainActivity

class PaybackPeriodDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        backAndCount()
        changeData()
    }

    private fun changeData() {
        // Header
        binding.header.textView.text = getString(R.string.different_title)

        // Perusahaan 1
        binding.input2.textViewTitle.text = getString(R.string.company_1)
        binding.input1.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input1.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input1.textField3.textField.hint = getString(R.string.year_1)
        binding.input1.textField4.textField.hint = getString(R.string.year_2)
        binding.input1.textField5.textField.hint = getString(R.string.year_3)

        // Perusahaan 2
        binding.input2.textViewTitle.text = getString(R.string.company_2)
        binding.input2.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input2.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input2.textField3.textField.hint = getString(R.string.year_1)
        binding.input2.textField4.textField.hint = getString(R.string.year_2)
        binding.input2.textField5.textField.hint = getString(R.string.year_3)

        // Perusahaan 3
        binding.input3.textViewTitle.text = getString(R.string.company_2)
        binding.input3.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input3.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input3.textField3.textField.hint = getString(R.string.year_1)
        binding.input3.textField4.textField.hint = getString(R.string.year_2)
        binding.input3.textField5.textField.hint = getString(R.string.year_3)
    }

    private fun backAndCount() {
        binding.header.iconBack.setOnClickListener() {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
        binding.btnHitung.button.setOnClickListener {
            val move = Intent(this, PaybackPeriodDifferentResult::class.java)
            startActivity(move)
        }
    }
}