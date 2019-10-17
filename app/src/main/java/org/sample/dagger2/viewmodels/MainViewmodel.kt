package org.sample.dagger2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.sample.dagger2.network.response.users.UsersResponse
import org.sample.dagger2.repositories.UserRepository
import javax.inject.Inject

class MainViewmodel @Inject constructor(val userRepository: UserRepository) : ViewModel() {
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()
    val userResponseLiveData = MutableLiveData<List<UsersResponse>>()
    val isRequestingLiveData = MutableLiveData<Boolean>()
    val toastLiveData = MutableLiveData<String>()


    fun getUsers(){
        isRequestingLiveData.postValue(true)

        compositeDisposable.add(userRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorComplete {
                Logger.e(it, "getUserApiRequest onErrorComplete")
                isRequestingLiveData.postValue(false)
                return@onErrorComplete true
            }
            .subscribe {
                Logger.d("request success")
                userResponseLiveData.postValue(it)

                isRequestingLiveData.postValue(false)
            })
    }

    fun getUser(id : Int){
        isRequestingLiveData.postValue(true)
        compositeDisposable.add(userRepository.getUserById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorComplete {
                Logger.e(it, "getUserApiRequest onErrorComplete")
                isRequestingLiveData.postValue(false)
                return@onErrorComplete true
            }
            .subscribe {
                Logger.d("request success")
                userResponseLiveData.postValue(it)

                isRequestingLiveData.postValue(false)
            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}