package com.example.myapplication

import android.app.Application
import com.example.data.quotes.api.QuotesApi
import com.example.data.quotes.datasource.*
import com.example.data.quotes.repository.QuotesRepository
import com.example.myapplication.presentation.QuotesViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

@Suppress("EXPERIMENTAL_API_USAGE")
val appModule = module {
    single { QuotesApi() }
}

@Suppress("EXPERIMENTAL_API_USAGE")
val repoModule = module {
    single<QuotesLocalDataSource> { QuotesDatabase(get()) }
    single<QuotesRemoteDataSource> { QuotesRemote(get()) }
    single<QuotesDataSource> {
        QuotesRepository(
            local = get<QuotesLocalDataSource>(),
            remote = get<QuotesRemoteDataSource>()
        )
    }
}

@InternalCoroutinesApi
val viewModelModule = module {
    viewModel {
        QuotesViewModel(get())
    }
}

@InternalCoroutinesApi
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}