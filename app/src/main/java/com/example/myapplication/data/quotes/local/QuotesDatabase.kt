package com.example.myapplication.data.quotes.local

import com.example.myapplication.data.quotes.QuotesDataSource
import com.example.myapplication.data.quotes.model.Quote
import kotlinx.coroutines.flow.Flow

class QuotesDatabase : QuotesDataSource {

    override fun getQuotes(): Flow<List<Quote>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateQuotes(quotes: List<Quote>) {
        TODO("Not yet implemented")
    }

}