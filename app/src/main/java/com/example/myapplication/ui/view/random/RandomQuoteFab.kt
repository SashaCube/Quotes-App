package com.example.myapplication.ui.view.random

import androidx.compose.foundation.Icon
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.presentation.QuotesViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun RandomQuoteFab(quotesViewModel: QuotesViewModel) {
    if (quotesViewModel.quotes.isNotEmpty()) {
        FloatingActionButton(
            onClick = {
                quotesViewModel.onRandomQuoteDialogFabClick()
            },
            shape = CircleShape,
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ) {
            RandomIcon()
            RandomQuoteAlertDialog(quotesViewModel.randomQuoteController)
        }
    }
}

@Composable
private fun RandomIcon() {
    val image = loadVectorResource(id = R.drawable.ic_baseline_casino_24)
    image.resource.resource?.let {
        Icon(
            asset = it,
            modifier = Modifier.size(40.dp),
        )
    }
}