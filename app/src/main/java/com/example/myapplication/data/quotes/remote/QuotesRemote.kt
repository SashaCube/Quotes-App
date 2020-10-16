package com.example.myapplication.data.quotes.remote

import com.example.myapplication.data.quotes.QuotesDataSource
import com.example.myapplication.data.api.QuotesApi
import com.example.myapplication.data.api.RefreshDataException
import com.example.myapplication.data.quotes.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class QuotesRemote(private val api: QuotesApi) : QuotesDataSource {

    override fun getQuotes() = flow { emit(api.getQuotes()) }
        //.catch { error(RefreshDataException()) }
        .flowOn(Dispatchers.IO)

    override suspend fun updateQuotes(quotes: List<Quote>) {
        // remote data source doesn't need this method
    }
}