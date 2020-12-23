package me.alberto.findcard.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.alberto.findcard.di.viewmodel.ViewModelFactory
import me.alberto.findcard.di.viewmodel.ViewModelKey
import me.alberto.findcard.screen.findcard.viewmodel.FindCardViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FindCardViewModel::class)
    abstract fun findCardViewModel(findCardViewModel: FindCardViewModel): ViewModel

}