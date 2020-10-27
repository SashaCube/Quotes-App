package com.example.data.quotes.repository

import com.example.domain.QuotesDataSource
import com.example.domain.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class QuotesRepository(
    private val local: QuotesDataSource,
    private val remote: QuotesDataSource
) : QuotesDataSource {

    /**
     * if [force] true, attempt to load data from remote data source,
     * else attempt to load data from local data source
     * If [force] true used remote, it caches data to local
     *
     * @param skip - The number of items to skip (for pagination).
     */
    override fun getQuotes(skip: Int, force: Boolean): Flow<List<Quote>> = flow {
        val dataSource = if (force) remote else local

        try {
            val data = dataSource.getQuotes(skip)
            data.collect {
                withContext(Dispatchers.IO) {
                    if (force) local.updateQuotes(it)
                }
                emit(it)
            }
        } catch (e: Exception) {
            if (force) {
                local.getQuotes(skip).collect {
                    emit(it)
                }
            }
        }
    }

    override suspend fun updateQuotes(quotes: List<Quote>) {
        withContext(Dispatchers.IO) {
            local.updateQuotes(quotes)
        }
    }
}