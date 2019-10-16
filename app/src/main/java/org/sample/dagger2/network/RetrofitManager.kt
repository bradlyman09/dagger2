package org.sample.dagger2.network

import com.google.gson.GsonBuilder
import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.GeneralSecurityException
import java.util.concurrent.TimeUnit

object RetrofitManager {
    private lateinit var retrofit: Retrofit

    val apiService : ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }

    init {
        var baseUrl = "https://jsonplaceholder.typicode.com/"

        //The Retrofit builder will have the client attached, in order to get connection logs
        try {
            val gson = GsonBuilder()
                .setDateFormat("dd MMM yyyy HH:mma")
                .create()

            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(buildHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        } catch (e: GeneralSecurityException) {
            Logger.e(e, "RetrofitManager init catch")
        }

    }

    @Throws(GeneralSecurityException::class)
    private fun buildHttpClient(): OkHttpClient {
        // The logging interceptor will be added to the http client
        val httpClient = OkHttpClient.Builder()

        //Logging interceptor is created
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return httpClient
            .addInterceptor(logging)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }
}