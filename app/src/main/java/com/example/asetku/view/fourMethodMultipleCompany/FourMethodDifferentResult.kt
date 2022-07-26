package com.example.asetku.view.fourMethodMultipleCompany

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityFourMethodDifferentResultBinding

class FourMethodDifferentResult : AppCompatActivity() {

    private lateinit var binding: ActivityFourMethodDifferentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourMethodDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

    }
}