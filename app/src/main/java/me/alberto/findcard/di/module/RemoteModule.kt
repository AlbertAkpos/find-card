package me.alberto.findcard.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import me.alberto.findcard.data.remote.restclient.RestClient
import me.alberto.findcard.di.scope.AppScope

@Module
class RemoteModule {
    @Provides
    @AppScope
    fun provideRestClient(context: Context): RestClient {
        return RestClient()
    }
}