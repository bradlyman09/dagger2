package org.sample.dagger2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import io.reactivex.Maybe
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.sample.dagger2.network.response.users.UsersResponse
import org.sample.dagger2.repositories.UserRepository
import javax.inject.Inject

class MainViewmodel @Inject constructor(val userRepository: UserRepository) : ViewModel() {
    val compositeDisposable : CompositeDisposable = CompositeDisposable()
    val testString = "MainViewModel"


    fun getUsers() : Maybe<List<UsersResponse>> {
        return userRepository.getUsers()
            .subscribeOn(Schedulers.io())
    }
}