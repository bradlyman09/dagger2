package org.sample.dagger2

import android.util.Log
import com.orhanobut.logger.Logger
import javax.inject.Inject

class Engine @Inject constructor(){
    init {
        Logger.d("Engine init")
    }
}