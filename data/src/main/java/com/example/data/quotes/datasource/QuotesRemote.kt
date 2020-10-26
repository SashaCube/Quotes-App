package com.example.data.quotes.datasource

import com.example.data.quotes.api.QuotesApi
import com.example.data.quotes.model.QuoteResponse
import com.example.domain.model.Quote
import io.ktor.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@KtorExperimentalAPI
class QuotesRemote constructor(
    private val api: QuotesApi
) : QuotesRemoteDataSource {

    override fun getQuotes(skip: Int, force: Boolean) = flow {
        emit(api.getQuotes(skip).results.map {
            it.toQuote()
        })
    }.flowOn(Dispatchers.IO)

    override suspend fun updateQuotes(quotes: List<Quote>) {
        // remote data source doesn't need this method
    }
}

fun QuoteResponse.toQuote() = Quote(text, author)