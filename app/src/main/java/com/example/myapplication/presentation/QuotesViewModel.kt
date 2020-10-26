package com.example.myapplication.presentation

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.quotes.datasource.QuotesDatabase
import com.example.data.quotes.repository.QuotesRepository
import com.example.domain.model.Quote
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class QuotesViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext

    init {
        viewModelScope.launch {
            QuotesRepository(
                local = QuotesDatabase(context)
            ).fetchQuotesAsFlow(true).collect {
                quotes = it
            }
        }
    }

    var quotes by mutableStateOf(listOf<Quote>())
        private set

    var randomQuoteController by mutableStateOf(
        RandomQuoteController(isOpened = false)
    )

    fun onRandomQuoteDialogFabClick() {
        randomQuoteController = RandomQuoteController(quotes)
    }

    fun getMoreQuotes() {
        viewModelScope.launch {
            QuotesRepository(
                local = QuotesDatabase(context)
            ).fetchQuotesAsFlow(true, skip = quotes.size).collect {
                quotes = quotes + it
            }
        }
    }
}
