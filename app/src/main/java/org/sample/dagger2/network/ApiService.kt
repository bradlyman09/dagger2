package org.sample.dagger2.network

import io.reactivex.Flowable
import io.reactivex.Maybe
import org.sample.dagger2.network.response.users.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{

    @GET("users")
    fun getUsers() : Maybe<List<UsersResponse>>

    @GET("users")
    fun getUserById(@Query("id") id : Int) : Maybe<List<UsersResponse>>
}