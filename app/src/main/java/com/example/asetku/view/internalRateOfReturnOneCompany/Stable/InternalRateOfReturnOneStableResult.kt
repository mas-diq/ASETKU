package com.example.asetku.view.internalRateOfReturnOneCompany.Stable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityInternalRateOfReturnOneStableResultBinding

class InternalRateOfReturnOneStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnOneStableResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalRateOfReturnOneStableResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}