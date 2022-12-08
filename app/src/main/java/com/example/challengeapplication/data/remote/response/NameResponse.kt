package com.example.challengeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class NameResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)