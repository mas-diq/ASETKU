package com.example.asetku.view.netPresentValueOneCompany.Different

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityNetPresentValueOneDifferentBinding

class NetPresentValueOneDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueOneDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetPresentValueOneDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}