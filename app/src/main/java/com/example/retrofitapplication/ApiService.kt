package com.example.retrofitapplication

import android.telecom.Call
import retrofit2.http.GET

interface ApiService {
    @GET("jokes/random/10")
    suspend fun getRandomJokes(): List<Joke>
}