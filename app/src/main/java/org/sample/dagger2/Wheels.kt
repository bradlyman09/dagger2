package org.sample.dagger2

import android.util.Log
import com.orhanobut.logger.Logger
import javax.inject.Inject

class Wheels @Inject constructor(){
    init {
        Logger.d("Wheels init")
    }
}