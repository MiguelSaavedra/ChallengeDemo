package com.example.challengeapplication.api

import com.example.challengeapplication.data.remote.response.DataUserResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("/api")
    suspend fun loginUser(): Response<DataUserResponse>

    companion object {
        fun getApi(): ApiService? {
            return ApiClient.client?.create(ApiService::class.java)
        }
    }
}