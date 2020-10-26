package com.example.myapplication.ui.view.quote

import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onActive
import com.example.domain.model.Quote

@Composable
fun QuoteScreen(quotes: List<Quote> = listOf(), onLastItemShowed: () -> Unit = {}) {
    if (quotes.isNotEmpty()) {
        val lastIndex = quotes.lastIndex
        LazyColumnForIndexed(items = quotes) { index, item ->
            if (lastIndex == index) {
                onActive {
                    onLastItemShowed()
                }
            }
            QuoteRow(item, onQuoteClicked = {})
        }
    }
}