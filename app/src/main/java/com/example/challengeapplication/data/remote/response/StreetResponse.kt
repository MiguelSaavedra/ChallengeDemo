package com.example.challengeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class StreetResponse(
    @SerializedName("number")
    val number: Int,
    @SerializedName("name")
    val name: String
)
