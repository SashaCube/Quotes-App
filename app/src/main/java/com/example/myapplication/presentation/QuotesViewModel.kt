package com.example.myapplication.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.api.RefreshDataException
import com.example.myapplication.data.quotes.QuotesRepository
import com.example.myapplication.data.quotes.model.Quote
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class QuotesViewModel : ViewModel() {

    init {
        viewModelScope.launch {
            try {
                QuotesRepository().fetchQuotesAsFlow(true).collect {
                    quotes = it
                }
            } catch (e: RefreshDataException) {
                quotes = listOf(Quote("ERROR", "ERROR"))
            }
        }
    }

    var quotes by mutableStateOf(listOf<Quote>())
        private set
}
