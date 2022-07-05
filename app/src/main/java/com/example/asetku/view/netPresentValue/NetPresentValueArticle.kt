package com.example.asetku.view.netPresentValue

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityNetPresentValueArticleBinding

class NetPresentValueArticle : AppCompatActivity() {

    private lateinit var binding: ActivityNetPresentValueArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetPresentValueArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        binding.imageView4.setOnClickListener {
            onBackPressed()
        }
    }
}