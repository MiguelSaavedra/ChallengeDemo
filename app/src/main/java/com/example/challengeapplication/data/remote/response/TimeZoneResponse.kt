package com.example.challengeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class TimeZoneResponse(
    @SerializedName("offset")
    val offset: String,
    @SerializedName("description")
    val description: String
)
