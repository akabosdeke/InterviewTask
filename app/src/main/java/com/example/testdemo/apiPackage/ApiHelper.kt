package com.example.testdemo.apiPackage

import com.example.testdemo.Response.ApiUser
import com.example.testdemo.Response.ResponseApiUser

interface ApiHelper {

    suspend fun getUsers(kid_id:String): ResponseApiUser



}