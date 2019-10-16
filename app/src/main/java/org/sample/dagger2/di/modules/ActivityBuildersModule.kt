package org.sample.dagger2.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.sample.dagger2.di.modules.main.MainModule
import org.sample.dagger2.di.modules.main.MainViewmodelModule
import org.sample.dagger2.views.MainActivity

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            MainViewmodelModule::class,
            MainModule::class
        ])

     abstract fun contributeMainActivity() : MainActivity
}