package com.example.searchfilms

import android.app.Application
import com.example.searchfilms.di.dataModule
import com.example.searchfilms.di.interactorModule
import com.example.searchfilms.di.repositoryModule
import com.example.searchfilms.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@MoviesApplication)
            modules(dataModule, repositoryModule, interactorModule, viewModelModule)
        }
    }
}