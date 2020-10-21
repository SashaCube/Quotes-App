package com.example.domain.services

import com.example.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuotesService {

    fun getQuotes(): Flow<List<Quote>>

    suspend fun updateQuotes(quotes: List<Quote>)
}