package com.example.presentation.mainfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.actiondomain.ActionsDomainModel
import com.example.domain.actiondomain.ActionsInteractor
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val actionsInteractor: ActionsInteractor
) : ViewModel() {

    private val _actionsDomainModel: MutableLiveData<ActionsDomainModel> by lazy {
        MutableLiveData<ActionsDomainModel>()
    }

    val actionsDomainModel: LiveData<ActionsDomainModel> = _actionsDomainModel

    fun getActions() {
        val aaa = actionsInteractor.getActions()
        _actionsDomainModel.value = aaa
    }
}