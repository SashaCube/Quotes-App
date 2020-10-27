package com.example.domain.usecase

import com.example.domain.QuotesDataSource
import com.example.domain.model.Quote
import kotlinx.coroutines.flow.collect

class GetRandomQuoteInteractor(
    private val quotesDataSource: QuotesDataSource
) : GetRandomQuoteUseCase {

    private var previousQuote = Quote()

    override suspend fun getRandomQuote(): Quote? {
        var quotes: List<Quote> = listOf()
        quotesDataSource.getQuotes(force = true).collect {
            quotes = it
        }

        return quotes.run {
            if (isNotEmpty()) {
                if (size > 1) {
                    filterNot { it == previousQuote }.random()
                } else {
                    random()
                }
            } else {
                null
            }
        }?.also {
            previousQuote = it
        }
    }
}