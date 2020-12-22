package me.alberto.findcard

import android.app.Application
import me.alberto.findcard.di.component.AppComponent
import me.alberto.findcard.di.component.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}