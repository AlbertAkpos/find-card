package me.alberto.findcard.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.alberto.findcard.di.module.DataModule
import me.alberto.findcard.di.module.RemoteModule
import me.alberto.findcard.di.module.ViewModelModule
import me.alberto.findcard.di.scope.AppScope
import me.alberto.findcard.screen.findcard.view.FindCardFragment

@AppScope
@Component(modules = [RemoteModule::class, ViewModelModule::class, DataModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: FindCardFragment)
}