package com.example.challengeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class PictureResponse(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)
