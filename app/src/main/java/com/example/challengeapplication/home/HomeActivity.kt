package com.example.challengeapplication.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeapplication.R
import com.example.challengeapplication.data.remote.response.ResultResponse
import com.example.challengeapplication.utils.Tools
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    var data: ResultResponse? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val gson = Gson()
        data = gson.fromJson(intent.getStringExtra("value"), ResultResponse::class.java)
        setListeners()
    }

    private fun setListeners() {
        val nameCompleted = data?.name?.title + " " + data?.name?.first + " " + data?.name?.last
        val emailStr = data?.email
        val contactStr = "Cel: " + data?.cell + "\n Tel: " + data?.phone
        val genderStr = if (data?.gender == "male") {
            getString(R.string.str_male)
        } else {
            getString(R.string.str_famale)
        }
        val birthdayStr = Tools.changeDateFormat(data?.dob?.date.toString())
        txt_name.text = nameCompleted
        txt_email.text = emailStr
        txt_contact.text = contactStr
        txt_gender.text = genderStr
        txt_birthday.text = birthdayStr
        val myUrl = data?.picture?.large
        Picasso.get().load(myUrl).into(img_profile)
    }
}