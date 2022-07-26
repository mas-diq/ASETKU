package com.example.asetku.view.netPresentValueOneCompany.Stable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityNetPresentValueOneStableResultBinding

class NetPresentValueOneStableResult : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueOneStableResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetPresentValueOneStableResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}