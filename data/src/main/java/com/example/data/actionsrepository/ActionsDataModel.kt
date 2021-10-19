package com.example.data.actionsrepository

import com.example.domain.actiondomain.ActionsDomainModel

data class ActionsDataModel(
    val name: String,
    val cost: Int,
    val date: String
)

fun ActionsDataModel.toDomain(): ActionsDomainModel = ActionsDomainModel(
    name = name,
    cost = cost * 100
)
