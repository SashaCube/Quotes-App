package com.example.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.domain.model.Quote
import com.example.domain.usecase.GetRandomQuoteUseCase
import com.example.myapplication.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

@InternalCoroutinesApi
class QuotesAppWidget : AppWidgetProvider() {

    private val getRandomQuoteUseCase by inject(GetRandomQuoteUseCase::class.java)

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // Perform this loop procedure for each App Widget that belongs to this provider
        appWidgetIds.forEach { appWidgetId ->
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {

        // Create an Intent
        val intent = Intent(context, QuotesAppWidget::class.java)
        intent.action = ACTION_QUOTE_APP_WIDGET

        val pendingIntent = PendingIntent.getBroadcast(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Get the layout for the App Widget and attach an on-click listener
        // to the button
        randomQuote { randomQuote ->
            val views: RemoteViews = setQuoteView(context, randomQuote).apply {
                setOnClickPendingIntent(R.id.button, pendingIntent)
            }

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (ACTION_QUOTE_APP_WIDGET == intent.action) {
            randomQuote { randomQuote ->
                val views: RemoteViews = setQuoteView(context, randomQuote)

                // This time we don't have widgetId. Reaching our widget with that way.
                val appWidget = ComponentName(context, QuotesAppWidget::class.java)
                val appWidgetManager = AppWidgetManager.getInstance(context)

                // Instruct the widget manager to update the widget
                appWidgetManager.updateAppWidget(appWidget, views)
            }
        }
    }

    private fun setQuoteView(
        context: Context,
        randomQuote: Quote
    ): RemoteViews {
        return RemoteViews(
            context.packageName,
            R.layout.appwidget_provider_layout
        ).apply {
            setTextViewText(R.id.tvContent, randomQuote.text)
            setTextViewText(R.id.tvAuthor, randomQuote.author)
        }
    }

    private fun randomQuote(block: (Quote) -> Unit = {}) = GlobalScope.launch {
        getRandomQuoteUseCase.getRandomQuote()?.let { block(it) }
    }

    companion object {
        private const val ACTION_QUOTE_APP_WIDGET = "ACTION_QUOTE_APP_WIDGET"
    }
}
