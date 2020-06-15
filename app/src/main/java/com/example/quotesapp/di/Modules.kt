package com.example.quotesapp.di

import org.koin.core.context.loadKoinModules

fun injectFeatureModules() = loadFeatureModule

private val loadFeatureModule by lazy {
    loadKoinModules(listOf(
            viewModelModule,
            databaseModule
    ))
}