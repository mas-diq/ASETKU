package com.example.asetku.view.internalRateOfReturn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityInternalRateOfReturnStableBinding

class InternalRateOfReturnStable : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalRateOfReturnStableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
    }
}