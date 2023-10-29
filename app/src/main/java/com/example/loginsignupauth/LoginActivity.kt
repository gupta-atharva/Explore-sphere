package com.example.loginsignupauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.TextView
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.loginsignupauth.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)

        val myTextView: TextView = findViewById(R.id.signupText)
        val text1: EditText = findViewById(R.id.loginEmail)
        val text2: EditText = findViewById(R.id.loginPassword)
        val loginbtn: Button = findViewById(R.id.loginButton)
        firebaseAuth = FirebaseAuth.getInstance()

        loginbtn.setOnClickListener {
            val email = text1.text.toString()
            val password = text2.text.toString()


            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }

//        binding.signupText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {    binding.signupText.text = "Androidly Button Long click"
//                startActivity(Intent(this, SignupActivity::class.java))
//                finish()
//            });

//        binding.signupText.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View?) {
//                // Code to execute when the button is clicked
//            }
//        })
            myTextView.setOnClickListener { view ->
                // Code to execute when the TextView is tapped
                // You can access the TextView view using 'view'
                startActivity(Intent(this, SignupActivity::class.java))
                finish()
            }
//            log.d("Working")

        }
    }
}