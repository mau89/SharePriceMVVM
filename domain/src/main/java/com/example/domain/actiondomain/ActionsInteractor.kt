package com.example.domain.actiondomain

class ActionsInteractor(
    private val actionsRepositoryInterface: ActionsRepositoryInterface
) {
    fun getActions(): ActionsDomainModel {
        return actionsRepositoryInterface.getAction()
    }
}