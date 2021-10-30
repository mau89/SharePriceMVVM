package com.example.sharepricemvvm

import android.app.Application
import com.example.data.actionsrepository.ActionsRepository
import com.example.domain.actiondomain.ActionsInteractor
import com.example.domain.actiondomain.GlobalDependenciesProvider
import com.example.domain.actiondomain.globalDependenciesProvider

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
//        globalDependenciesProvider = object : GlobalDependenciesProvider {
//            override fun provideActionsInteractor(): ActionsInteractor {
//                return ActionsInteractor(ActionsRepository())
//            }
//        }
    }
}