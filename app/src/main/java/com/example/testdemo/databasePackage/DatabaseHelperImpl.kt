package com.example.testdemo.databasePackage

import com.example.testdemo.databasePackage.entity.User

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

   // override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()

}