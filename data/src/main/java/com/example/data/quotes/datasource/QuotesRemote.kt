package com.example.data.quotes.datasource

import com.example.data.quotes.api.QuotesApi
import com.example.data.quotes.model.QuoteResponse
import com.example.domain.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class QuotesRemote(private val api: QuotesApi) : QuotesDataSource {

    override fun getQuotes(skip: Int) = flow {
        emit(api.getQuotes(skip).results.map {
            it.toQuote()
        })
    }.flowOn(Dispatchers.IO)

    override suspend fun updateQuotes(quotes: List<Quote>) {
        // remote data source doesn't need this method
    }
}

fun QuoteResponse.toQuote() = Quote(text, author)