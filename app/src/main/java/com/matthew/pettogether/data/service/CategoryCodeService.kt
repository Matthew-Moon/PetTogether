package com.matthew.pettogether.data.service

import com.matthew.pettogether.data.dto.response.CategoryCodeResponse
import retrofit2.http.GET

interface CategoryCodeService {
    @GET("categoryCode")
    suspend fun getCategoryCode(): CategoryCodeResponse
}

