package com.example.data.quotes.model

import com.google.gson.annotations.SerializedName

data class QuoteResponse(
    @SerializedName("content")
    val text: String,
    @SerializedName("author")
    val author: String
)