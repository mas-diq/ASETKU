package com.example.asetku.view.paybackPeriod

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityPaybackPeriodArticleBinding

class PaybackPeriodArticle : AppCompatActivity() {

    private lateinit var binding: ActivityPaybackPeriodArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaybackPeriodArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        binding.imageView4.setOnClickListener {
            onBackPressed()
        }
    }
}