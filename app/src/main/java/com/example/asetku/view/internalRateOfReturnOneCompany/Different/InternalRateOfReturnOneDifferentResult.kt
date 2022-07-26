package com.example.asetku.view.internalRateOfReturnOneCompany.Different

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityInternalRateOfReturnOneDifferentResultBinding

class InternalRateOfReturnOneDifferentResult : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnOneDifferentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalRateOfReturnOneDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}