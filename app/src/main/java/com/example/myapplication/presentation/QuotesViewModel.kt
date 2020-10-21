package com.example.myapplication.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.quotes.repository.QuotesRepository
import com.example.domain.model.Quote
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class QuotesViewModel : ViewModel() {

    init {
        viewModelScope.launch {
            QuotesRepository().fetchQuotesAsFlow(true).collect {
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
}
