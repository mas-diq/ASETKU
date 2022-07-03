package com.example.asetku.view.netPresentValue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityNetPresentValueDifferentResultBinding

class NetPresentValueDifferentResult : AppCompatActivity() {

    lateinit var binding: ActivityNetPresentValueDifferentResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetPresentValueDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
    }
}