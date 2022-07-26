package com.example.asetku.view.netPresentValueOneCompany.Different

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityNetPresentValueOneDifferentResultBinding

class NetPresentValueOneDifferentResult : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueOneDifferentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetPresentValueOneDifferentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}