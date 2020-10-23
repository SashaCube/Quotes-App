package com.example.data.quotes.repository

import com.example.data.quotes.api.QuotesApi
import com.example.data.quotes.datasource.QuotesDataSource
import com.example.data.quotes.datasource.QuotesRemote
import com.example.domain.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class QuotesRepository(
    private val local: QuotesDataSource,
    private val remote: QuotesDataSource = QuotesRemote(QuotesApi())
) {
    /**
     * if [force] true, attempt to load data from remote data source,
     * else attempt to load data from local data source
     * If [force] true used remote, it caches data to local
     */
    fun fetchQuotesAsFlow(force: Boolean = false): Flow<List<Quote>> = flow {
        val dataSource = if (force) remote else local

        try {
            val data = dataSource.getQuotes()
            data.collect {
                withContext(Dispatchers.IO) {
                    if (force) local.updateQuotes(it)
                }
                emit(it)
            }
        } catch (e: Exception) {
            if (force) {
                local.getQuotes().collect {
                    emit(it)
                }
            }
        }
    }
}