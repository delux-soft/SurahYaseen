package com.example.surahyaseen.utils

import com.example.surahyaseen.api.CalenderAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object CalendarAPIManager {
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.API_KEY)
        .build()

    val calendarAPI: CalenderAPI = retrofit.create(CalenderAPI::class.java)

}