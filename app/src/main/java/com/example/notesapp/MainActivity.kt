package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var tvLoginLink: TextView
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnSignUp:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignUp = findViewById(R.id.btnSignUp)
        tvLoginLink = findViewById(R.id.tvLoginLink)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)




        Firebase.initialize(this)
        auth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
        if(etEmail.text.trim().toString().isNotEmpty() || etPassword.text.trim().toString().isNotEmpty()){
                createUser(etEmail.text.trim().toString(), etPassword.text.trim().toString())
                var intent = Intent(baseContext,AddQuoteActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(baseContext,"please enter the required fields",Toast.LENGTH_LONG).show()
            }

        }
    }
    fun createUser(email:String,password:String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    Log.e("Task Message","Task is successful")
                }
                else{
                    Log.e("Task Message","Failed "+ task.exception)
                }

            }
    }

    override fun onStart() {
        super.onStart()

        var intent = Intent(baseContext,AddQuoteActivity::class.java)
        startActivity(intent)

    }
}