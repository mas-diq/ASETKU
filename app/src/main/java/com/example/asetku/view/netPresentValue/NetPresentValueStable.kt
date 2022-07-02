package com.example.asetku.view.netPresentValue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityNetPresentValueStableBinding

class NetPresentValueStable : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueStableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetPresentValueStableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
    }
}