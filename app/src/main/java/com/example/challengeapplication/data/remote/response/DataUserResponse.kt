package com.example.challengeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class DataUserResponse(
    @SerializedName("results")
    val results: List<ResultResponse>,
    @SerializedName("info")
    val info: InfoResponse
)
