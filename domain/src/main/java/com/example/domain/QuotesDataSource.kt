package com.example.domain

import com.example.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuotesDataSource {

    fun getQuotes(skip: Int = 0, force: Boolean = false): Flow<List<Quote>>

    suspend fun updateQuotes(quotes: List<Quote>)
}