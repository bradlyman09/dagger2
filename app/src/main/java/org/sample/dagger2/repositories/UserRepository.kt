package org.sample.dagger2.repositories

import io.reactivex.Flowable
import io.reactivex.Maybe
import org.sample.dagger2.network.RetrofitManager
import org.sample.dagger2.network.response.users.UsersResponse
import javax.inject.Inject

class UserRepository @Inject constructor(val retrofitManager : RetrofitManager){

    fun getUsers() : Maybe<List<UsersResponse>> {
        return retrofitManager.apiService.getUsers()
    }

    fun getUserById(userId : Int) :  Maybe<List<UsersResponse>>{
        return retrofitManager.apiService.getUserById(userId)
    }
}