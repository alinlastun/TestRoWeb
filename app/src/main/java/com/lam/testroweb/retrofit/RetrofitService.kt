package com.lam.testroweb.retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val BASE_URL = "http://api.themoviedb.org/3/"
    val API_KEY = "199815a2ea88ffa18464aebfd5a23b51"
    val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w200/"
    val BACKDROP_BASE_URL = "https://image.tmdb.org/t/p/w780/"

    val interfaces: RetrofitInterface

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        interfaces = retrofit.create(RetrofitInterface::class.java)
    }

    private var instance: RetrofitService? = null

    @Synchronized
    fun getInstance(): RetrofitService {
        if (instance != null) {
            instance
        } else {
            instance = RetrofitService()
        }
        return instance as RetrofitService
    }
}