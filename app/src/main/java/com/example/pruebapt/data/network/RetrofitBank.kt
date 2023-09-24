package com.example.pruebapt.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBank {
    fun api(): ApiServiceBank {
        val retrofit: Retrofit.Builder by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okhttpClient = OkHttpClient.Builder()
            okhttpClient.addInterceptor(interceptor)
            /*
            * configuracion necesaria para retrofit
            * .base url
            * .client
            * */
            Retrofit.Builder()
                .baseUrl("https://dev.obtenmas.com")
                .client(okhttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
        return retrofit
            .build()
            .create(ApiServiceBank::class.java)
    }
}