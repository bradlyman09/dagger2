package org.sample.dagger2.di.modules.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.sample.dagger2.di.ViewModelKey2
import org.sample.dagger2.viewmodels.MainViewmodel

@Module
abstract class MainViewmodelModule{

    @Binds
    @IntoMap
//    @ViewModelKey(MainViewmodel::class)
    @ViewModelKey2(MainViewmodel::class)
    abstract fun bindMainViewModel(mainViewmodel : MainViewmodel) : ViewModel
}