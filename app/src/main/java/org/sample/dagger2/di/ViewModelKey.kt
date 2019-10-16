package org.sample.dagger2.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.Documented
import kotlin.reflect.KClass


//@Documented
////@Target(ElementType.METHOD)
//@Target(AnnotationTarget.FUNCTION)
//@Retention(AnnotationRetention.RUNTIME)
//@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)