package com.example.asetku.view.netPresentValueOneCompany.Stable

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityNetPresentValueOneStableBinding
import com.example.asetku.view.MainActivity
import com.example.asetku.view.netPresentValueMultipleCompany.NetPresentValueArticle

class NetPresentValueOneStable : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueOneStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetPresentValueOneStableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getInfo()
        changeData()
        count()
        back()
    }

    private fun getInfo() {
        binding.info.setOnClickListener {
            val move = Intent(this, NetPresentValueArticle::class.java)
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
                val move = Intent(this, NetPresentValueOneStableResult::class.java)
                val bundleData = Bundle()
                bundleData.apply {
                    putString(
                        "initialInvestment",
                        binding.input1.textField1.textEdit.text.toString()
                    )
                    putString("cashFlow", binding.input1.textField2.textEdit.text.toString())
                    putString("year", binding.input1.textField3.textEdit.text.toString())
                    putString("discountRate", binding.input1.textField4.textEdit.text.toString())
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
        binding.input1.textViewTitle.text = getString(R.string.company)
        binding.input1.textField1.textField.hint = getString(R.string.initial_investment)
        binding.input1.textField2.textField.hint = getString(R.string.cash_flow)
        binding.input1.textField3.textField.hint = getString(R.string.year)
        binding.input1.textField4.textField.hint = getString(R.string.discount_rate)
    }

    private fun checkNull(): Boolean {
        return binding.input1.textField1.textEdit.text.isNullOrBlank() ||
                binding.input1.textField2.textEdit.text.isNullOrBlank() ||
                binding.input1.textField3.textEdit.text.isNullOrBlank() ||
                binding.input1.textField4.textEdit.text.isNullOrBlank()
    }
}