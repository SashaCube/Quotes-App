package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.example.myapplication.presentation.QuotesViewModel
import com.example.myapplication.ui.common.MyApplicationTheme
import com.example.myapplication.ui.view.quote.QuoteScreen
import com.example.myapplication.ui.view.random.RandomQuoteFab
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class QuotesActivity : AppCompatActivity() {

    private val quotesViewModel by viewModels<QuotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                QuotesActivityScreen(quotesViewModel)
            }
        }
    }
}

@InternalCoroutinesApi
@Composable
fun QuotesActivityScreen(quotesViewModel: QuotesViewModel) {
    Scaffold(
        floatingActionButton = {
            RandomQuoteFab(quotesViewModel)
        },
        bodyContent = {
            QuoteScreen(
                quotesViewModel.quotes,
                onLastItemShowed = {
                    quotesViewModel.getMoreQuotes()
                }
            )
        }
    )
}