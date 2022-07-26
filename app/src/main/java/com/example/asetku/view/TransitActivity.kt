package com.example.asetku.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityTransitBinding

class TransitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

    }
}