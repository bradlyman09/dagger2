package org.sample.dagger2.di.modules.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import org.sample.dagger2.di.ViewModelKey
import org.sample.dagger2.di.ViewModelKey2
import org.sample.dagger2.network.RetrofitManager
import org.sample.dagger2.repositories.UserRepository
import org.sample.dagger2.viewmodels.MainViewmodel

@Module
class MainModule{

    @Module companion object{
        @Provides
        @JvmStatic
        fun providesUsersRepository(retrofitManager : RetrofitManager) : UserRepository{
            return UserRepository(retrofitManager)
        }
    }

//    @Binds
//    @IntoMap
////    @ViewModelKey(MainViewmodel::class)
//    @ViewModelKey2(MainViewmodel::class)
//    abstract fun bindMainViewModel(mainViewmodel : MainViewmodel) : ViewModel
}
