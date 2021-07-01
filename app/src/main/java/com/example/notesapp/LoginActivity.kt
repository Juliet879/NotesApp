package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var tvSignUpLink:TextView
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Firebase.initialize(this)
        auth = FirebaseAuth.getInstance()
        tvSignUpLink = findViewById(R.id.tvSignUpLink)
        editEmail = findViewById(R.id.editEmail)
        editPassword = findViewById(R.id.editPassword)
        btnLogin = findViewById(R.id.btnLogin)


        tvSignUpLink.setOnClickListener {
            var backIntent = Intent(baseContext,MainActivity::class.java)
            startActivity(backIntent)
        }

        btnLogin.setOnClickListener {
            if (editEmail.text.trim().toString().isNotEmpty() || editPassword.text.trim().toString().isNotEmpty()){

                var intent = Intent(baseContext, AddQuoteActivity::class.java)
                startActivity(intent)
            }
        }
    }
    fun signInUser(email:String,password:String){

    }
}