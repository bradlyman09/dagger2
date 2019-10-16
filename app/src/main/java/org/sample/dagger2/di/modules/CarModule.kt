package org.sample.dagger2.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.sample.dagger2.views.MainActivity

@Module
abstract class CarModule {//@Inject constructor(val engine: Engine, val wheels: Wheels){

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity


}