package com.example.searchfilms.di

import com.example.searchfilms.domain.api.MoviesInteractor
import com.example.searchfilms.domain.impl.MoviesInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    single<MoviesInteractor> {
        MoviesInteractorImpl(get())
    }

}