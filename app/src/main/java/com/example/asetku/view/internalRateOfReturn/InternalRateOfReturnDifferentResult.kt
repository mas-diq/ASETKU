package com.example.asetku.view.internalRateOfReturn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityInternalRateOfReturnDifferentResultBinding
import com.example.asetku.viewmodel.AccountingViewModel

class InternalRateOfReturnDifferentResult : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnDifferentResultBinding
    private lateinit var viewModel: AccountingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInternalRateOfReturnDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}