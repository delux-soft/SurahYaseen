package com.example.surahyaseen.api

import com.example.surahyaseen.model.CalenderResponseModel
import com.example.surahyaseen.utils.GenericResult
import retrofit2.http.GET
import retrofit2.http.Path

interface CalenderAPI {

    @GET("gToHCalendar/{month}/{year}")
    suspend fun getCalenderData(
        @Path("month") month: String,
        @Path("year") year: String
    ): GenericResult<CalenderResponseModel>
}