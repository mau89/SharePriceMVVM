package com.example.sharepricemvvm

import android.content.Context
import android.content.res.Resources
import com.example.data.actionsrepository.ActionsRepository
import com.example.domain.actiondomain.ActionsInteractor
import com.example.domain.actiondomain.ActionsRepositoryInterface
import com.example.domain.actiondomain.DomainDiProvider
import com.example.presentation.mainfragment.MainViewModel
import dagger.*
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : DomainDiProvider {

    val context: Context

    val resourceManager: Resources

    override fun actionsInteractor(): ActionsInteractor

    @Component.Factory
    interface Builder {
        fun build(
            @BindsInstance context: Context,
            @BindsInstance resource: Resources,
            appModule: AppModule
        ): AppComponent
    }
}

@Module(includes = [AppModule.Bindings::class])
class AppModule {

    @Provides
    fun provideActionsInteractor(
        actionsRepositoryInterface: ActionsRepositoryInterface
    ): ActionsInteractor {
        return ActionsInteractor(
            actionsRepositoryInterface = actionsRepositoryInterface
        )
    }

    @Module
    interface Bindings {
        @Binds
        fun bindActionsRepository(actionsRepository: ActionsRepository): ActionsRepositoryInterface
    }
}
