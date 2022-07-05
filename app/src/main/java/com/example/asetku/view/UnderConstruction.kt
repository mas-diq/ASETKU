package com.example.asetku.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityUnderConstructionBinding

class UnderConstruction : AppCompatActivity() {

    private lateinit var binding: ActivityUnderConstructionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnderConstructionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.button.setOnClickListener {
            onBackPressed()
        }
    }
}