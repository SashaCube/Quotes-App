package com.example.data.quotes.datasource

import android.content.Context
import androidx.room.Room
import com.example.data.quotes.database.AppDatabase
import com.example.data.quotes.database.toEntity
import com.example.data.quotes.database.toModel
import com.example.domain.model.Quote
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class QuotesDatabase(context: Context) : QuotesDataSource {

    private val db = Room.databaseBuilder(
        context, AppDatabase::class.java, "database-name"
    ).build()

    override fun getQuotes() = flow {
        db.quoteDao().getAll().collect {
            emit(it.map { quoteEntity ->
                quoteEntity.toModel()
            })
        }
    }

    override suspend fun updateQuotes(quotes: List<Quote>) {
        db.quoteDao().insertAll(quotes.map { it.toEntity() })
    }
}