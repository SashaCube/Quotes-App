package com.example.myapplication.data.quotes

import com.example.myapplication.data.api.QuotesApi
import com.example.myapplication.data.quotes.local.QuotesDatabase
import com.example.myapplication.data.quotes.model.Quote
import com.example.myapplication.data.quotes.remote.QuotesRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class QuotesRepository(
    private val local: QuotesDataSource,
    private val remote: QuotesDataSource
) {
    constructor() : this(remote = QuotesRemote(QuotesApi()), local = QuotesDatabase())

    /**
     * if [force] true, attempt to load data from remote data source,
     * else attempt to load data from local data source
     * If [force] true used remote, it caches data to local
     */
    fun fetchQuotesAsFlow(force: Boolean = false): Flow<List<Quote>> = flow {
        val dataSource = if (force) remote else local
        val data = dataSource.getQuotes()

        data.collect {
            if (force) local.updateQuotes(it)
            emit(it)
        }
    }
}