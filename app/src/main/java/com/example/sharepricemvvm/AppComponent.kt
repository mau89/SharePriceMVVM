package com.example.sharepricemvvm

import com.example.data.actionsrepository.ActionsRepository
import com.example.domain.actiondomain.ActionsInteractor
import com.example.domain.actiondomain.ActionsRepositoryInterface
import com.example.presentation.mainfragment.MainViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    val mainViewModel: MainViewModel
}

@Module(includes = [AppBindModule::class])
object AppModule {

    @Provides
    fun provideMainViewModel(
        actionsInteractor: ActionsInteractor
    ): MainViewModel {
        return MainViewModel(
            actionsInteractor = actionsInteractor
        )
    }

    @Provides
    fun provideActionsInteractor(
        actionsRepositoryInterface: ActionsRepositoryInterface
    ): ActionsInteractor {
        return ActionsInteractor(
            actionsRepositoryInterface = actionsRepositoryInterface
        )
    }

}

@Module
interface AppBindModule {
    @Binds
    fun bindActionsRepository_to_ActionsRepositoryInterface(
        actionsRepository: ActionsRepository
    ): ActionsRepositoryInterface
}