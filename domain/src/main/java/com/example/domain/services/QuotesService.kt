package com.example.domain.services

import com.example.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuotesService {

    fun getQuotes(skip: Int = 0): Flow<List<Quote>>

    suspend fun updateQuotes(quotes: List<Quote>)
}