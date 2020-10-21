package com.example.myapplication.ui.view.quote

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Quote

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
            modifier = modifier.align(Alignment.Start),
            text = quote.text,
            style = TextStyle(
                fontSize = 14.sp
            )
        )
        Text(
            modifier = modifier
                .align(Alignment.End)
                .padding(top = 4.dp),
            text = quote.author,
            style = TextStyle(
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic
            )
        )
    }
}