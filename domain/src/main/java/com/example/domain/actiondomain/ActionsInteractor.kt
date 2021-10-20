package com.example.domain.actiondomain

class ActionsInteractor(private val actionsRepo: ActionsRepositoryInterface) {
    fun getActions(): ActionsDomainModel {
        return actionsRepo.getAction()
    }
}