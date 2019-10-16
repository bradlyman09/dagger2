package org.sample.dagger2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import javax.inject.Provider
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
class SampleViewModelFactory @Inject constructor(private val creators : Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        var creator = creators.get(modelClass) ?:
            creators.asIterable().firstOrNull {
                modelClass.isAssignableFrom(it.key)
            }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }


}