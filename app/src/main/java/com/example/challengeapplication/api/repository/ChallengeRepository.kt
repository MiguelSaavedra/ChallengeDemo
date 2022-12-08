package com.example.challengeapplication.api.repository

import com.example.challengeapplication.api.ApiService
import com.example.challengeapplication.data.remote.response.DataUserResponse
import retrofit2.Response

class ChallengeRepository {
    suspend fun loginUser(): Response<DataUserResponse>? {
        return  ApiService.getApi()?.loginUser()
    }
}