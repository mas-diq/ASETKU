package com.example.asetku.view.paybackPeriod

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.R
import com.example.asetku.databinding.ActivityPaybackPeriodDifferentResultBinding
import com.example.asetku.view.MainActivity

class PaybackPeriodDifferentResult : AppCompatActivity() {

    lateinit var binding: ActivityPaybackPeriodDifferentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
        changeData()
        back()
    }

    private fun changeData() {
        binding.header.textView.text = getString(R.string.different_title)
    }

    private fun back() {
        binding.header.iconBack.setOnClickListener() {
            val move = Intent(this, PaybackPeriodDifferent::class.java)
            startActivity(move)
        }
        binding.btnBack.button.setOnClickListener {
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
    }
}