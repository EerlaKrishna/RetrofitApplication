package com.example.retrofitapplication

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("id")val id:Int,
    @SerializedName("setup")val setup:String,
    @SerializedName("punchline")val punchline:String
)
