package com.example.testdemo.apiPackage

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(kid_id:String) = apiService.getUsers(kid_id =kid_id )
}