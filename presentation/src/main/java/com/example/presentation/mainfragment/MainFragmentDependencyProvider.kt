package com.example.presentation.mainfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.actiondomain.globalDependenciesProvider

object MainFragmentDependencyProvider {

    fun inject(fragment: MainFragment) {
        fragment.viewModel = ViewModelProvider(
            fragment,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel(globalDependenciesProvider.provideActionsInteractor()) as T
                }
            }
        )[MainViewModel::class.java]
    }
}