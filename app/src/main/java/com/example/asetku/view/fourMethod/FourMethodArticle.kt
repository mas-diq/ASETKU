package com.example.asetku.view.fourMethod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityFourMethodArticleBinding

class FourMethodArticle : AppCompatActivity() {

    private lateinit var binding: ActivityFourMethodArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourMethodArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
    }
}