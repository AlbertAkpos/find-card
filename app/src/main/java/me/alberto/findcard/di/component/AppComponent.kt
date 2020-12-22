package me.alberto.findcard.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.alberto.findcard.di.module.RemoteModule
import me.alberto.findcard.di.scope.AppScope

@AppScope
@Component(modules = [RemoteModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}