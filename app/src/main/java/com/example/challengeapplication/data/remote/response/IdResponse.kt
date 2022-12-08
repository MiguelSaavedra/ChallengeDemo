package com.example.challengeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class IdResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String
)
