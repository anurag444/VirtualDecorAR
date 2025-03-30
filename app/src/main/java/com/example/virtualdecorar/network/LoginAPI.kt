//package com.example.virtualdecorar.network
//
//import com.example.virtualdecorar.models.User
//import retrofit2.Response
//import retrofit2.http.Body
//import retrofit2.http.POST
//import java.util.Objects
//
//interface LoginAPI{
//
//    @POST("registeration")
//    suspend fun register(@Body user: User): Response<String>
//
//    @POST("login")
//    suspend fun login(@Body user: User): Response<User>
//}