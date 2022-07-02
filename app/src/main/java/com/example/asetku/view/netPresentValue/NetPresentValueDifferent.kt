package com.example.asetku.view.netPresentValue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityNetPresentValueDifferentBinding

class NetPresentValueDifferent : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueDifferentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetPresentValueDifferentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

    }
}