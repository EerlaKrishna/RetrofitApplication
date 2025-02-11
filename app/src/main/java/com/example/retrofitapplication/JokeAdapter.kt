package com.example.retrofitapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class JokeAdapter(private val jokes: List<Joke>) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val setupTextView: TextView = itemView.findViewById(R.id.setupTextView)
        val punchlineTextView: TextView = itemView.findViewById(R.id.punchlineTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokes[position]
        holder.setupTextView.text = joke.setup
        holder.punchlineTextView.text = joke.punchline
    }

    override fun getItemCount(): Int = jokes.size
}
