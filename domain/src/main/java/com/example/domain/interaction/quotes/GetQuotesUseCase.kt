package com.example.domain.interaction.quotes

import com.example.domain.interaction.Result
import com.example.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface GetQuotesUseCase {

    fun execute(): Flow<Result<List<Quote>>>
}