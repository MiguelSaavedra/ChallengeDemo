package com.example.challengeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class InfoResponse(
    @SerializedName("seed")
    val seed: String,
    @SerializedName("results")
    val results: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("version")
    val version: String
)
