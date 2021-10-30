package com.example.presentation.mainfragment.di

import com.example.domain.actiondomain.DomainDiProvider
import com.example.presentation.mainfragment.MainFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [MainFragmentModule::class],
    dependencies = [DomainDiProvider::class]
)
interface MainFragmentComponent {

    fun inject(fragment: MainFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: MainFragment,
            domainDiProvider: DomainDiProvider,
            mainFragmentModule: MainFragmentModule
        ): MainFragmentComponent
    }
}