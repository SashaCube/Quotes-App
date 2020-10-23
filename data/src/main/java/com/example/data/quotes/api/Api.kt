package com.example.data.quotes.api

import com.example.data.quotes.model.QuotesResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.util.*

@KtorExperimentalAPI
internal val ktorClient = HttpClient(Android) {
    install(JsonFeature) {
        serializer = GsonSerializer()
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
    }
}

@KtorExperimentalAPI
class QuotesApi(private val client: HttpClient = ktorClient) {
    suspend fun getQuotes(): QuotesResponse = client.get(getQuotesUrl)

    companion object {
        private const val getQuotesUrl = "https://api.quotable.io/quotes"
    }
}
