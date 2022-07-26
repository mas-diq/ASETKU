package com.example.asetku.view.netPresentValueOneCompany.Stable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityNetPresentValueOneStableBinding

class NetPresentValueOneStable : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueOneStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetPresentValueOneStableBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}