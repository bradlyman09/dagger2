package org.sample.dagger2.di.modules

import dagger.Module
import dagger.Provides
import org.sample.dagger2.network.RetrofitManager
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule {

    @Module companion object{
        @JvmStatic
        @Provides
        fun testString() : String{
            return "AppModule testString"
        }

//        @Singleton
        @Provides
        @JvmStatic
        fun providesRetrofitManager() : RetrofitManager{
            return RetrofitManager
        }
    }
}