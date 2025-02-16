package com.matthew.pettogether.domain.repository

import com.matthew.pettogether.data.dto.response.AreaCodeResponse

interface AreaCodeRepository {
    suspend fun getAreaCode(): AreaCodeResponse
}