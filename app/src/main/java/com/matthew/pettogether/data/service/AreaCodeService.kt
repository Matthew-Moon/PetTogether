package com.matthew.pettogether.data.service

import com.matthew.pettogether.data.dto.response.AreaCodeResponse
import com.matthew.pettogether.data.dto.response.CategoryCodeResponse
import retrofit2.http.GET

interface AreaCodeService {
    @GET("areaCode")
    suspend fun getAreaCode(): AreaCodeResponse
}

