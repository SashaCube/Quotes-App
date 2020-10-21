package com.example.data.quotes.datasource

import android.util.Log
import com.example.domain.model.Quote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QuotesDatabase : QuotesDataSource {

    override fun getQuotes(): Flow<List<Quote>> {
        Log.i(TAG, "getQuotes")
        return flow {
            Quote("Quote from database", "Author")
        }
    }

    override suspend fun updateQuotes(quotes: List<Quote>) {
        Log.i(TAG, "updateQuotes")
    }

    companion object {
        private const val TAG = "QuotesDatabase"
    }
}