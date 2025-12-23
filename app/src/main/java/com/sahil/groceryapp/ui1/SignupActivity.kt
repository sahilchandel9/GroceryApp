package com.sahil.groceryapp.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.sahil.groceryapp.LoginActivity
import com.sahil.groceryapp.R

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()



        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val signupBtn = findViewById<Button>(R.id.btnSignup)

        signupBtn.setOnClickListener {

            val userEmail = email.text.toString()
            val userPassword = password.text.toString().trim()

            if(userEmail.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(this,"Enter email & password",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
             fun createAccount(email: String, password: String) {

                auth.createUserWithEmailAndPassword(userEmail, userPassword)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}


