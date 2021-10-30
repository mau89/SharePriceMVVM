package com.example.sharepricemvvm

import android.app.Application
import com.example.data.actionsrepository.ActionsRepository
import com.example.domain.actiondomain.ActionsInteractor
import com.example.domain.actiondomain.GlobalDependenciesProvider
import com.example.domain.actiondomain.domainDiProvider
import com.example.domain.actiondomain.globalDependenciesProvider

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .factory()
            .build(
                context = this,
                resource = resources,
                AppModule()
            )

        domainDiProvider = appComponent
    }
}