package org.sample.dagger2.views

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.orhanobut.logger.Logger
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.sample.dagger2.R
import org.sample.dagger2.viewmodels.MainViewmodel
import org.sample.dagger2.viewmodels.SampleViewModelFactory
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    lateinit var viewmodel : MainViewmodel

    @Inject
    lateinit var sampleViewModelFactory : SampleViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProviders.of(this, sampleViewModelFactory)
            .get(MainViewmodel::class.java)

        initView()
        setUpObservers()
    }

    private fun initView(){
        button_get_user.setOnClickListener{
            if(!TextUtils.isEmpty(edittext_user_id.text.toString())){
                viewmodel.getUser(
                    Integer.parseInt(edittext_user_id.text.toString())
                )
            }

        }
    }

    fun setUpObservers(){
        viewmodel.userResponseLiveData.observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                textview_username.text = it.first().username
            }
            else{
                textview_username.text = ""
                viewmodel.toastLiveData.postValue("User not found!")
            }
        })

        viewmodel.isRequestingLiveData.observe(this, Observer {
            progress_circular.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewmodel.toastLiveData.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }


}
