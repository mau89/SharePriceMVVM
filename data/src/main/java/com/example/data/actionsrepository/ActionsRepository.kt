package com.example.data.actionsrepository

import com.example.domain.actiondomain.ActionsDomainModel
import com.example.domain.actiondomain.ActionsRepositoryInterface
import java.text.DateFormat

class ActionsRepository : ActionsRepositoryInterface {

    override fun getAction(): ActionsDomainModel {
        return ActionsDataModel(
            name = "name",
            cost = 1000,
            date = DateFormat.getInstance().format(System.currentTimeMillis())
        ).toDomain()
    }
}