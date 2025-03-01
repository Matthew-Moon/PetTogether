package com.matthew.pettogether.data.service

import com.matthew.pettogether.data.dto.response.LocationBasedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationBasedService {
    @GET("KorPetTourService/locationBasedList")
    suspend fun getLocationBasedList(
        @Query("contentTypeId") contentTypeId: Int,
        @Query("mapX") mapX: Double,
        @Query("mapY") mapY: Double,
        @Query("radius") radius: Int
    ): LocationBasedResponse
} 