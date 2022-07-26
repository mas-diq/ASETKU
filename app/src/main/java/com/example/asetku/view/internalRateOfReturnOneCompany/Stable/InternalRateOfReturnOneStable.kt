package com.example.asetku.view.internalRateOfReturnOneCompany.Stable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityInternalRateOfReturnOneStableBinding

class InternalRateOfReturnOneStable : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnOneStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalRateOfReturnOneStableBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}