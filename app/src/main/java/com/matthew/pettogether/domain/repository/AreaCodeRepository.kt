package com.matthew.pettogether.domain.repository

import com.matthew.pettogether.domain.model.Area

interface AreaCodeRepository {
    suspend fun getAreaCode(): List<Area>
}