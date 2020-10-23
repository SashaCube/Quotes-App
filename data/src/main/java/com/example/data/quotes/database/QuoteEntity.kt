package com.example.data.quotes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Quote

@Entity
data class QuoteEntity(
    @PrimaryKey val text: String,
    @ColumnInfo(name = "author") val author: String
)

fun QuoteEntity.toModel() = Quote(text, author)

fun Quote.toEntity() = QuoteEntity(text, author)