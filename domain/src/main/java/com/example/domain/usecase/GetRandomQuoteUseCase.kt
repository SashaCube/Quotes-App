package com.example.domain.usecase

import com.example.domain.model.Quote

interface GetRandomQuoteUseCase {

    suspend fun getRandomQuote(): Quote?

}