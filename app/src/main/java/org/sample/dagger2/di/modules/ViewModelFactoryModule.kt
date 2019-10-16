package org.sample.dagger2.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import org.sample.dagger2.viewmodels.SampleViewModelFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun  bindViewModelFactory(viewModelFactory: SampleViewModelFactory)
            : ViewModelProvider.Factory
}