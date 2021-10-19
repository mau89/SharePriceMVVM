package com.example.data.actionsrepository

import com.example.domain.actiondomain.ActionsDomainModel
import com.example.domain.actiondomain.ActionsInteractorInterface
import java.text.DateFormat

class ActionsRepository : ActionsInteractorInterface {

    override fun getAction(): ActionsDomainModel {
        return ActionsDataModel(
            name = "name",
            cost = 1000,
            date = DateFormat.getInstance().format(System.currentTimeMillis())
        ).toDomain()
    }
}