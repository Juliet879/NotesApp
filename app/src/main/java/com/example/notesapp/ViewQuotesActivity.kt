package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot

class ViewQuotesActivity : AppCompatActivity() {
//    lateinit var rvQuotes: RecyclerView
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

    fun saveFireStore(author: String, quoted: String) {
        val db = FirebaseFirestore.getInstance()
        val quote: MutableMap<String, Any> = HashMap()
        quote["author"] = author
        quote["quote"] = quoted

        db.collection("quotes")
            .add(quote)
            .addOnSuccessListener {
                Toast.makeText(baseContext, "quote added successfully", Toast.LENGTH_LONG).show()
                readFireStoreData()
            }
            .addOnFailureListener {
                Toast.makeText(baseContext, "quote failed to add", Toast.LENGTH_LONG).show()
            }
    }

    fun readFireStoreData() {
        val db = FirebaseFirestore.getInstance()

        db.collection("quotes")
            .get()
            .addOnCompleteListener {


                var quotesList = mutableListOf<Quotes>()
                if (it.isSuccessful) {
                    var results:StringBuffer = StringBuffer()
                       for (quote in it.result!!){
                            results.append(quote.data.getValue("author")).append(" ")
                                .append(quote.data.getValue("quote")).append(" \n\n\n")


//                           var quotesAdapter = QuoteRecyclerViewAdapter(quotesList)
//                           rvQuotes.adapter = quotesAdapter
//                           rvQuotes.layoutManager = LinearLayoutManager(baseContext)

                       }
                    tvWriter.setText(results)
                }
            }
    }
}
