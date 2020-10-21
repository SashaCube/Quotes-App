package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.domain.model.Quote
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
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                shape = CircleShape,
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White
            ) {
                val image = loadVectorResource(id = R.drawable.ic_baseline_casino_24)
                // loadImageResource will load the drawable asynchronous
                image.resource.resource?.let {
                    Icon(
                        asset = it,
                        modifier = Modifier.size(40.dp),
                    )
                }
            }
        },
        bodyContent = {
            ScrollableColumn {
                quotes.map {
                    QuoteRow(it, onQuoteClicked = {})
                }
            }
        }
    )
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
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth()
    ) {
        Text(
            modifier = modifier.align(Start),
            text = quote.text,
            style = TextStyle(
                fontSize = 14.sp
            )
        )
        Text(
            modifier = modifier
                .align(End)
                .padding(top = 4.dp),
            text = quote.author,
            style = TextStyle(
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic
            )
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        QuoteScreen(
            listOf(
                Quote("Friendship is Love without his wings!", "Lord Byron"),
                Quote("A short saying often contains much wisdom.", "Sophocles")
            )
        )
    }
}