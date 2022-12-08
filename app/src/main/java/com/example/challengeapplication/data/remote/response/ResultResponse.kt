package com.example.challengeapplication.data.remote.response

import android.graphics.Picture
import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: NameResponse,
    @SerializedName("location")
    val location: LocationResponse,
    @SerializedName("email")
    val email: String,
    @SerializedName("login")
    val login: LoginResponse,
    @SerializedName("dob")
    val dob: DobResponse,
    @SerializedName("registered")
    val registered: RegisteredResponse,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("cell")
    val cell: String,
    @SerializedName("id")
    val id: IdResponse,
    @SerializedName("picture")
    val picture: PictureResponse,
    @SerializedName("nat")
    val nat: String
)
