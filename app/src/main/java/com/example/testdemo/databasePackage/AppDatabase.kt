package com.example.testdemo.databasePackage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testdemo.databasePackage.entity.User
import com.example.testdemo.databasePackage.entity.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}