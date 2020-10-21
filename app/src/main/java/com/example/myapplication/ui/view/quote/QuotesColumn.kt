package com.example.myapplication.ui.view.quote

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.runtime.Composable
import com.example.domain.model.Quote

@Composable
fun QuoteScreen(quotes: List<Quote> = listOf()) {
    ScrollableColumn {
        quotes.map {
            QuoteRow(it, onQuoteClicked = {})
        }
    }
}