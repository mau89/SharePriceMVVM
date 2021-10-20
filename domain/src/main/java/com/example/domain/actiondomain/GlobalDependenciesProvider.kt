package com.example.domain.actiondomain

lateinit var globalDependenciesProvider: GlobalDependenciesProvider

interface GlobalDependenciesProvider {

    fun provideActionsInteractor(): ActionsInteractor
}