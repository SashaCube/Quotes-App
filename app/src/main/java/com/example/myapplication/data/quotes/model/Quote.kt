package com.example.myapplication.data.quotes.model

import kotlinx.serialization.Serializable

@Serializable
data class Quote(val text: String, val author: String)