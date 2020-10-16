package com.example.myapplication.data.api

import com.example.myapplication.data.quotes.model.Quote
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

internal val kotlinxSerializer = KotlinxSerializer(
    Json {
        isLenient = true
        ignoreUnknownKeys = true
    }
)

internal val ktorClient = HttpClient {
    install(JsonFeature) {
        serializer = kotlinxSerializer
        accept(ContentType.Application.Any)
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
    }
}

class QuotesApi(private val client: HttpClient = ktorClient) {
    suspend fun getQuotes(): List<Quote> = client.get(getQuotesUrl)

    companion object {
        private const val getQuotesUrl = "https://type.fit/api/quotes"
    }
}
