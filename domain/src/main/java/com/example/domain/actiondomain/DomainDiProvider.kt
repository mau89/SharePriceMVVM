package com.example.domain.actiondomain

lateinit var domainDiProvider: DomainDiProvider

interface DomainDiProvider {

    fun actionsInteractor(): ActionsInteractor
}