package com.example.data.quotes.model

import com.google.gson.annotations.SerializedName

data class QuotesResponse(
    @SerializedName("results")
    val results: List<QuoteResponse>
)