package com.example.challengeapplication.utils

import java.text.SimpleDateFormat
class Tools {
    companion object {
        fun changeDateFormat(date: String): String {
            val initDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date)
            val formatter = SimpleDateFormat("dd MMMM yyyy")
            return formatter.format(initDate)
        }
    }


}