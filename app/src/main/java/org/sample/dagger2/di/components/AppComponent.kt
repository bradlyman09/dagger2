package org.sample.dagger2.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import org.sample.dagger2.SampleApplication
import org.sample.dagger2.di.modules.ActivityBuildersModule
import org.sample.dagger2.di.modules.AppModule
import org.sample.dagger2.di.modules.CarModule
import org.sample.dagger2.di.modules.ViewModelFactoryModule

@Component(modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuildersModule::class,
        ViewModelFactoryModule::class
])
interface AppComponent : AndroidInjector<SampleApplication>{
//    fun getCar() : Car


//    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application : Application) : Builder

        fun build() : AppComponent
    }
}