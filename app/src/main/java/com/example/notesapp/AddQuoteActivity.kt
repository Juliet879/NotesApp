package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AddQuoteActivity : AppCompatActivity() {
    lateinit var btnViewQuotes :Button
    lateinit var edAuthor :EditText
    lateinit var edQuote : EditText
    lateinit var btnView : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_quote)

        btnView = findViewById(R.id.btnView)
        edAuthor = findViewById(R.id.edAuthor)
        edQuote  = findViewById(R.id.edQuote)
        btnViewQuotes = findViewById(R.id.btnViewQuotes)

        btnView.setOnClickListener {
            var viewIntent = Intent(baseContext,ViewQuotesActivity::class.java)
            startActivity(viewIntent)
        }

        btnViewQuotes.setOnClickListener {
            var intent = Intent(baseContext,ViewQuotesActivity::class.java)
            intent.putExtra("author",edAuthor.text.toString())
            intent.putExtra("quote",edQuote.text.toString())
            startActivity(intent)
        }



    }
}