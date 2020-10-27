package com.example.myapplication.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.QuotesDataSource
import com.example.domain.model.Quote
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class QuotesViewModel(
    private val quotesDataSource: QuotesDataSource
) : ViewModel() {

    init {
        viewModelScope.launch {
            quotesDataSource.getQuotes(force = true).collect {
                quotes = it
            }
        }
    }

    var quotes by mutableStateOf(listOf<Quote>())
        private set

    var moreQuotesAreLoading by mutableStateOf(false)
        private set

    var randomQuoteController by mutableStateOf(
        RandomQuoteController(isOpened = false)
    )

    fun onRandomQuoteDialogFabClick() {
        randomQuoteController = RandomQuoteController(quotes)
    }

    fun getMoreQuotes() {
        viewModelScope.launch {
            moreQuotesAreLoading = true
            quotesDataSource.getQuotes(force = true, skip = quotes.size).collect {
                quotes = quotes + it
                moreQuotesAreLoading = false
            }
        }
    }
}
