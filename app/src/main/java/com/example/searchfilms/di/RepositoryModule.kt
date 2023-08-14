package com.example.searchfilms.di

import com.example.searchfilms.data.MoviesRepositoryImpl
import com.example.searchfilms.data.conventers.MovieCastConverter
import com.example.searchfilms.domain.api.MoviesRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory { MovieCastConverter() }

    single<MoviesRepository> {
        MoviesRepositoryImpl(get(), get())
    }

}