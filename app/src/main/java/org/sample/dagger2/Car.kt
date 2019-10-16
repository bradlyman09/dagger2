package org.sample.dagger2

import android.util.Log
import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Car @Inject constructor(val engine: Engine, val wheels: Wheels){

    init {
        Logger.d("Car init")
    }

    fun drive(){
        Logger.d("car  drive")
    }

//    @Provides
//    fun providesEngine() : Engine{
//        return engine
//    }
//
//    @Provides
//    fun providesWheels() : Wheels{
//        return wheels
//    }
}