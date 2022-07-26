package com.example.asetku.view.profitabilityIndexMultipleCompany

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityProfitabilityIndexArticleBinding

class ProfitabilityIndexArticle : AppCompatActivity() {

    private lateinit var binding: ActivityProfitabilityIndexArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfitabilityIndexArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        binding.imageView4.setOnClickListener {
            onBackPressed()
        }
    }
}