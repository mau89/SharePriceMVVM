package com.example.presentation.mainfragment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.actiondomain.ActionsInteractor
import com.example.presentation.mainfragment.MainFragment
import com.example.presentation.mainfragment.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {

    @Provides
    fun provideViewModel(
        fragment: MainFragment,
        interactor: ActionsInteractor
    ): MainViewModel {
        return ViewModelProvider(
            fragment,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel(interactor) as T
                }
            }
        )[MainViewModel::class.java]
    }
}