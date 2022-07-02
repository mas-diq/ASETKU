package com.example.asetku.view.internalRateOfReturn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asetku.databinding.ActivityInternalRateOfReturnArticleBinding

class InternalRateOfReturnArticle : AppCompatActivity() {

    private lateinit var binding: ActivityInternalRateOfReturnArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalRateOfReturnArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
    }
}