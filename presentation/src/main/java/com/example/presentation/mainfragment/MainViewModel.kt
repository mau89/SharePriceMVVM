package com.example.presentation.mainfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.actiondomain.ActionsDomainModel
import com.example.domain.actiondomain.ActionsInteractor

class MainViewModel(
    private val actionsInteractor: ActionsInteractor
) : ViewModel() {

    private val _actionsDomainModel: MutableLiveData<ActionsDomainModel> by lazy {
        MutableLiveData<ActionsDomainModel>()
    }

    val actionsDomainModel: LiveData<ActionsDomainModel> = _actionsDomainModel

    fun getActions() {
        actionsInteractor.getActions()
    }
}