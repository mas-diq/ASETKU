package com.example.asetku.view.internalRateOfReturnOneCompany.Different

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityInternalRateOfReturnOneDifferentBinding

class InternalRateOfReturnOneDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnOneDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalRateOfReturnOneDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}