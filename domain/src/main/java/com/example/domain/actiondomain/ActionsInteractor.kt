package com.example.domain.actiondomain

class ActionsInteractor(private val actionsInteractors: ActionsInteractorInterface) {
    fun getActions(): ActionsDomainModel {
        return actionsInteractors.getAction()
    }
}