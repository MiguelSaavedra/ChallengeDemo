package com.example.challengeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("street")
    val street: StreetResponse,
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("postcode")
    val postcode: Int,
    @SerializedName("coordinates")
    val coordinates: CoordinatesResponse,
    @SerializedName("timezone")
    val timezone: TimeZoneResponse
)