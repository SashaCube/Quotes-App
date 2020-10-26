package com.example.myapplication.ui.view.quote

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.presentation.QuotesViewModel
import com.example.myapplication.ui.view.Progress
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun QuoteScreen(quotesViewModel: QuotesViewModel) {
    Box {
        QuoteColumn(
            quotesViewModel.quotes,
            onLastItemShowed = { quotesViewModel.getMoreQuotes() }
        )
        if (quotesViewModel.moreQuotesAreLoading) {
            Progress(modifier = Modifier.align(Alignment.Center))
        }
    }
}
