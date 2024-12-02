package com.vk.vkiddemo.data.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.vk.vkiddemo.data.api.WebApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addNetworkInterceptor(ChuckerInterceptor.Builder(get()).build())
            .build()
    }

    single {
        GsonConverterFactory.create()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://example.com")
            .client(get<OkHttpClient>())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    single {
        get<Retrofit>().create(WebApi::class.java)
    }
}