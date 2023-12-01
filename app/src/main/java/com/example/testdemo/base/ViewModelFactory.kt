package com.example.testdemo.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testdemo.apiPackage.ApiHelper
import com.example.testdemo.databasePackage.DatabaseHelper
import com.example.testdemo.viewModel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(apiHelper, dbHelper) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }

}