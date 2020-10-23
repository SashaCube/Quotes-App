package com.example.data.quotes.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
}
