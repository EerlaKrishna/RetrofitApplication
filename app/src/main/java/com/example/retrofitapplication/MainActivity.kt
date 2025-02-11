package com.example.retrofitapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapplication.ApiClient
import com.example.retrofitapplication.Joke
import com.example.retrofitapplication.JokeAdapter
import com.example.retrofitapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val call = ApiClient.apiService.getRandomJokes()
        call.enqueue(object : Callback<List<Joke>> {
            override fun onResponse(call: Call<List<Joke>>, response: Response<List<Joke>>) {
                if (response.isSuccessful) {
                    response.body()?.let { jokes ->
                        jokeAdapter = JokeAdapter(jokes)
                        recyclerView.adapter = jokeAdapter
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Failed to fetch jokes", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Joke>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to fetch jokes", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

