package org.sample.dagger2.di;

import androidx.lifecycle.ViewModel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;
/** kotlin has a bug so for now use this java class
 *  reference : https://github.com/google/dagger/issues/1478
 **/

@MapKey
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelKey2 {
    Class<? extends ViewModel> value();
}
