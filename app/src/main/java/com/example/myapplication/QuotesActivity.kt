package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.myapplication.data.quotes.model.Quote
import com.example.myapplication.presentation.QuotesViewModel
import com.example.myapplication.ui.MyApplicationTheme
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
    QuoteScreen(quotesViewModel.quotes)
}

@Composable
fun QuoteScreen(quotes: List<Quote> = listOf()) {
    Column {
        quotes.map {
            QuoteRow(it, onQuoteClicked = {})
        }
    }
}

@Composable
fun QuoteRow(
    quote: Quote,
    onQuoteClicked: (Quote) -> Unit = {},
    modifier: Modifier = Modifier
) {
    require(quote.text.isNotEmpty())

    Column(
        modifier = modifier
            .clickable { onQuoteClicked(quote) }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(quote.text)
        Text(quote.author)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        QuoteScreen(listOf(
            Quote("90", "89"),
            Quote("12", "56")
        ))
    }
}