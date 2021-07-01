package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ViewQuotesActivity : AppCompatActivity() {
    lateinit var rvQuotes :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_quotes)

        rvQuotes = findViewById(R.id.rvQuotes)

        var authorIntent = intent.getStringExtra("author")
        var quotesIntent = intent.getStringExtra("quote")

        saveFireStore(authorIntent.toString(),quotesIntent.toString())

    }
    fun saveFireStore(author:String,quote:String){
        val db = FirebaseFirestore.getInstance()
        var quote:MutableMap<String,Any> = HashMap()
        quote["author"] = author
        quote["quote"]  = quote

        db.collection("quotes")
            .add("quotes")
            .addOnSuccessListener {
                Toast.makeText(baseContext,"quote added successfully",Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(baseContext,"quote failed to add",Toast.LENGTH_LONG).show()
            }
    }
}