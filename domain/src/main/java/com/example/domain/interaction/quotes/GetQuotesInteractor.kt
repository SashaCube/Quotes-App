package com.example.domain.interaction.quotes

import com.example.domain.interaction.Result
import com.example.domain.model.Quote
import com.example.domain.services.QuotesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetQuotesInteractor(private val quotesService: QuotesService) : GetQuotesUseCase {

    override fun execute(): Flow<Result<List<Quote>>> = flow {
        quotesService.getQuotes().collect {
            val result = it.toSuccessResult() //todo HANDLE ERRORS
            emit(result)
        }
    }.flowOn(Dispatchers.IO)
}

fun List<Quote>.toSuccessResult() = Result.Success(this)