package com.example.challengeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class DobResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("age")
    val age: Int)
