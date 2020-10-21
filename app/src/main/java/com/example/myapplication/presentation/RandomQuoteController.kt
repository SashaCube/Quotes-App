package com.example.myapplication.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.domain.model.Quote

class RandomQuoteController(
    private val quotes: List<Quote> = listOf(),
    isOpened: Boolean = true
) {

    var randomQuote by mutableStateOf(EmptyQuote)
        private set

    var isDialogOpen by mutableStateOf(isOpened)
        private set

    init {
        randomizeQuote()
    }

    fun onNextButtonClick() {
        randomizeQuote()
    }

    fun onCloseButtonClick() {
        isDialogOpen = false
    }

    fun onDismiss() {
        isDialogOpen = false
    }

    private fun randomizeQuote() {
        if (quotes.isNotEmpty() && quotes.count() > 1) {
            randomQuote = quotes.filterNot { it == randomQuote }.random()
        }
    }

    companion object {
        val EmptyQuote = Quote()
    }
}