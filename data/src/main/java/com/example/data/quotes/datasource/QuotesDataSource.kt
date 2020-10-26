package com.example.data.quotes.datasource

import com.example.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuotesDataSource {

    fun getQuotes(skip: Int = 0, force: Boolean = false): Flow<List<Quote>>

    suspend fun updateQuotes(quotes: List<Quote>)
}

interface QuotesRemoteDataSource : QuotesDataSource

interface QuotesLocalDataSource : QuotesDataSource