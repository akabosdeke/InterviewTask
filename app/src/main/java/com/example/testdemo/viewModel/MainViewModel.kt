package com.example.testdemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testdemo.Response.ApiUser
import com.example.testdemo.Response.ResponseApiUser
import com.example.testdemo.apiPackage.ApiHelper
import com.example.testdemo.base.UiState
import com.example.testdemo.databasePackage.DatabaseHelper
import kotlinx.coroutines.launch

class MainViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    val uiState = MutableLiveData<UiState<ResponseApiUser>>()

    init {
        fetchUsers("378")
    }

    fun fetchUsers(kid_id:String) {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                val usersFromApi = apiHelper.getUsers(kid_id)
                uiState.postValue(UiState.Success(usersFromApi))
            } catch (e: Exception) {
                uiState.postValue(UiState.Error(e.toString()))
            }
        }
    }


}