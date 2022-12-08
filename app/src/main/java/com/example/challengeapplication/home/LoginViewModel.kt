package com.example.challengeapplication.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.challengeapplication.api.repository.ChallengeRepository
import com.example.challengeapplication.data.remote.response.BaseResponse
import com.example.challengeapplication.data.remote.response.DataUserResponse
import kotlinx.coroutines.launch

class LoginViewModel (application: Application) : AndroidViewModel(application) {

    val userRepo = ChallengeRepository()
    val loginResult: MutableLiveData<BaseResponse<DataUserResponse>> = MutableLiveData()

    fun loginUser() {

        loginResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val response = userRepo.loginUser()
                if (response?.code() == 200) {
                    loginResult.value = BaseResponse.Success(response.body())
                } else {
                    loginResult.value = BaseResponse.Error(response?.message())
                }

            } catch (ex: Exception) {
                loginResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}