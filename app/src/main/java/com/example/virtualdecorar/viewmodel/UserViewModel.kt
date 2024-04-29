package com.example.virtualdecorar.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virtualdecorar.models.User
import com.example.virtualdecorar.network.LoginAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val api: LoginAPI): ViewModel() {

    fun login(email: String, password: String){
        viewModelScope.launch {
            val response = api.login(User(ID = 0, Email = email, UserName = "", Password = password))
            Log.d("LoginScreen", "Response: " + response.body().toString())
       }
    }
}