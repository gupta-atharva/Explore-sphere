package com.example.loginsignupauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AboutRecommendations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_recommendations)
        val aboutRecommend1 : TextView = findViewById(R.id.aboutRecommendation)
        val aboutText = intent.getStringExtra("string2")
        aboutRecommend1.text = aboutText
    }
}