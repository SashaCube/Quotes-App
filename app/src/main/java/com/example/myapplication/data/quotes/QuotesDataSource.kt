package com.example.myapplication.data.quotes

import com.example.myapplication.data.quotes.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuotesDataSource {

    fun getQuotes(): Flow<List<Quote>>

    suspend fun updateQuotes(quotes: List<Quote>)
}