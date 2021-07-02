package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ViewQuotesActivity : AppCompatActivity() {
    lateinit var rvQuotes: RecyclerView
    lateinit var tvWriter :TextView
    lateinit var tvQuote :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_quotes)


        tvWriter = findViewById(R.id.tvWriter)
        tvQuote = findViewById(R.id.tvQuote)
//        rvQuotes = findViewById(R.id.rvQuotes)

        val authorIntent = intent.getStringExtra("author")
        val quotesIntent = intent.getStringExtra("quote")

        tvWriter.text = authorIntent.toString()
        tvQuote.text = quotesIntent.toString()

        saveFireStore(authorIntent.toString(),quotesIntent.toString())
        readFireStoreData()
    }

    fun saveFireStore(author: String, quote: String) {
        var db = FirebaseFirestore.getInstance()
        var quote: MutableMap<String, Any> = HashMap()
        quote["author"] = author
        quote["quote"] = quote

        db.collection("quotes")
            .add("quotes")
            .addOnSuccessListener {
                Toast.makeText(baseContext, "quote added successfully", Toast.LENGTH_LONG).show()
                readFireStoreData()
            }
            .addOnFailureListener {
                Toast.makeText(baseContext, "quote failed to add", Toast.LENGTH_LONG).show()
            }
    }

    fun readFireStoreData() {
        var db = FirebaseFirestore.getInstance()

        db.collection("quotes")
            .get()
            .addOnCompleteListener { task ->
                var quotesList = mutableListOf<Quotes>()
                if (task.isSuccessful) {
//                      for ()
                }
            }
    }
}