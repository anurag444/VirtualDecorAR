package com.example.virtualdecorar.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    val ngrokUrl = "https://3d1d-2607-fea8-999-ca00-e226-d7cd-3d58-92f9.ngrok-free.app"

//    @Singleton
//    @Provides
//    fun providesRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(ngrokUrl + "/api/Registeration/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun providesRegisterService(retrofit: Retrofit): LoginAPI {
//        return retrofit.create(LoginAPI::class.java)
//    }

}