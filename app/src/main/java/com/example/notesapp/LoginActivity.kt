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
            val backIntent = Intent(baseContext,MainActivity::class.java)
            startActivity(backIntent)
        }

        btnLogin.setOnClickListener {
            if (editEmail.text.trim().toString().isNotEmpty() || editPassword.text.trim().toString().isNotEmpty()){
                   signInUser(editEmail.text.trim().toString(),editPassword.text.trim().toString())
            }
            else{
                Toast.makeText(baseContext,"Please enter required fields",Toast.LENGTH_LONG).show()
            }
        }
    }
    fun signInUser(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val intent = Intent(baseContext,AddQuoteActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(baseContext,"Error !!" + task.exception,Toast.LENGTH_LONG).show()
                }
            }

    }
}