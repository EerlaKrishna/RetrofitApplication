package com.example.retrofitapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var jokeAdapter: JokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchJokes()
    }

    private fun fetchJokes() {
        lifecycleScope.launch {
            try {
                val jokes = ApiClient.apiService.getRandomJokes()
                jokeAdapter = JokeAdapter(jokes)
                recyclerView.adapter = jokeAdapter
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Failed to fetch jokes", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

