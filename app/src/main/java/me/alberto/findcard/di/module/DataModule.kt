package me.alberto.findcard.di.module

import dagger.Binds
import dagger.Module
import me.alberto.findcard.data.domain.repository.IRepository
import me.alberto.findcard.data.domain.repository.Repository
import me.alberto.findcard.data.remote.source.IRemoteSource
import me.alberto.findcard.data.remote.source.RemoteSource

@Module
abstract class DataModule {
    @Binds
    abstract fun bindsRepository(repository: Repository): IRepository

    @Binds
    abstract fun bindsRemoteSource(remoteSource: RemoteSource): IRemoteSource

}