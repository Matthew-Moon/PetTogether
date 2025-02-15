package com.matthew.pettogether.domain.repository

import com.matthew.pettogether.data.dto.response.CategoryCodeResponse

interface CategoryCodeRepository {
    suspend fun getCategoryCode(): CategoryCodeResponse
}