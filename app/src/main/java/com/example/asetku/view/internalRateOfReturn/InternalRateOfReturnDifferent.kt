package com.example.asetku.view.internalRateOfReturn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityInternalRateOfReturnDifferentBinding

class InternalRateOfReturnDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInternalRateOfReturnDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
    }
}