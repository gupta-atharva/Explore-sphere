package com.example.loginsignupauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.appcompat.widget.Toolbar


class RecommendedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommended)

        val recommended1 : Button = findViewById(R.id.firstRecommendation)
//        val recommended2 : TextView = findViewById(R.id.secondRecommendation)
        val recommended3 : Button = findViewById(R.id.thirdRecommendation)
//        val recommended4 : TextView = findViewById(R.id.fourthRecommendation)
        val recommended5 : Button = findViewById(R.id.fifthRecommendation)
//        val recommended6 : TextView = findViewById(R.id.sixthRecommendation)

        val firstText = intent.getStringExtra("string1")
        recommended1.text = firstText
        val secondText = intent.getStringExtra("string2")
//        recommended2.text = secondText
        val thirdText = intent.getStringExtra("string3")
        recommended3.text = thirdText
        val fourthText = intent.getStringExtra("string4")
//        recommended4.text = fourthText
        val fifthText = intent.getStringExtra("string5")
        recommended5.text = fifthText
        val sixthText = intent.getStringExtra("string6")
//        recommended6.text = sixthText

        recommended1.setOnClickListener {
            val intent = Intent(this@RecommendedActivity, AboutRecommendations::class.java)
            intent.putExtra("string2", secondText)
            startActivity(intent)
            finish()
        }
        recommended3.setOnClickListener {
            val intent = Intent(this@RecommendedActivity, AboutRecommendations::class.java)
            intent.putExtra("string2", fourthText)
            startActivity(intent)
            finish()
        }
        recommended5.setOnClickListener {
            val intent = Intent(this@RecommendedActivity, AboutRecommendations::class.java)
            intent.putExtra("string2", sixthText)
            startActivity(intent)
            finish()
        }

    }
}