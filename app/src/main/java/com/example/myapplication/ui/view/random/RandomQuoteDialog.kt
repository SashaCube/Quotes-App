package com.example.myapplication.ui.view.random

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.presentation.RandomQuoteController
import com.example.myapplication.ui.view.quote.QuoteRow
import com.example.myapplication.util.string
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@Composable
fun RandomQuoteAlertDialog(
    controller: RandomQuoteController
) {
    if (!controller.isDialogOpen) {
        return
    }
    val modifier = Modifier
        .animateContentSize(animSpec = spring())

    AlertDialog(
        modifier = modifier,
        onDismissRequest = { controller.onDismiss() },
        title = { Text(text = string(R.string.random_quote)) },
        text = {
            Column(modifier = modifier) {
                QuoteRow(
                    modifier = modifier,
                    quote = controller.randomQuote
                )
                Spacer(modifier = Modifier.preferredHeight(8.dp))
            }
        },
        dismissButton = {
            Button(
                onClick = { controller.onCloseButtonClick() }
            ) { Text(string(R.string.close)) }
            Spacer(modifier = Modifier.preferredHeight(8.dp))
        },
        confirmButton = {
            Button(
                onClick = { controller.onNextButtonClick() }
            ) { Text(string(R.string.next)) }
            Spacer(modifier = Modifier.preferredHeight(8.dp))
        }
    )
}
