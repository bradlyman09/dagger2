package org.sample.dagger2.views

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.orhanobut.logger.Logger
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import org.sample.dagger2.R
import org.sample.dagger2.viewmodels.MainViewmodel
import org.sample.dagger2.viewmodels.SampleViewModelFactory
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var testString : String

    lateinit var viewmodel : MainViewmodel

    @Inject
    lateinit var sampleViewModelFactory : SampleViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProviders.of(this, sampleViewModelFactory)
            .get(MainViewmodel::class.java)

        getUserApiRequest()
    }

    fun getUserApiRequest(){
        viewmodel.compositeDisposable.add(
            viewmodel.getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorComplete {
                    Logger.e(it, "getUserApiRequest onErrorComplete")
                    return@onErrorComplete true
                }
                .subscribe {
                    Logger.d("request success")
                }
        )
    }


}
