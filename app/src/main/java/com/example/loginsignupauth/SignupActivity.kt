package com.example.loginsignupauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.loginsignupauth.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

//    private lateinit var myEditText: EditText
//    private lateinit var myEditText2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_signup)


        val myEditText: EditText = findViewById(R.id.signupEmail)
        val myEditText2: EditText = findViewById(R.id.signupPassword)

        val logintext: TextView = findViewById(R.id.loginText)
        val signup: Button = findViewById(R.id.signupButton)

        firebaseAuth = FirebaseAuth.getInstance()
        signup.setOnClickListener {
            val email = myEditText.text.toString()
            val password = myEditText2.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) {task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Log.e("FirebaseAuth", "User registration failed: $email $password") // Log the error
                            Toast.makeText(this, "Signup Unsuccessful", Toast.LENGTH_SHORT).show()

                        }
                    }
            } else {
                Toast.makeText(this, "Enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        logintext.setOnClickListener { view ->
            // Code to execute when the TextView is tapped
            // You can access the TextView view using 'view'
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}