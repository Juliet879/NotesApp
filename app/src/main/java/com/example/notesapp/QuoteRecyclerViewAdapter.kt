package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteRecyclerViewAdapter(var quotesList: MutableList<Quotes>):RecyclerView.Adapter<QuoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
         var itemView = LayoutInflater.from(parent.context).inflate(R.layout.quote_item_list,parent,false)
        return QuoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        var currentQuotes =  quotesList.get(position)
        holder.tvAuthor.text = currentQuotes.author
        holder.tvQuote.text  = currentQuotes.author

    }

    override fun getItemCount(): Int {
        return quotesList.size

    }
}
class QuoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvAuthor = itemView.findViewById<TextView>(R.id.tvWriter)
    var tvQuote = itemView.findViewById<TextView>(R.id.tvQuote
    )
}