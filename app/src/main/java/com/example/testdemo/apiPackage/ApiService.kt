package com.example.testdemo.apiPackage

import com.example.testdemo.Response.ApiUser
import com.example.testdemo.Response.ResponseApiUser
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("list")
    suspend fun getUsers(
        @Query("kid_id") kid_id:String
    ): ResponseApiUser
}