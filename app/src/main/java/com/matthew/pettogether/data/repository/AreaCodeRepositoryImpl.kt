package com.matthew.pettogether.data.repository

import com.matthew.pettogether.data.dto.response.AreaCodeResponse
import com.matthew.pettogether.data.dto.response.CategoryCodeResponse
import com.matthew.pettogether.data.service.AreaCodeService
import com.matthew.pettogether.data.service.CategoryCodeService
import com.matthew.pettogether.domain.repository.AreaCodeRepository
import com.matthew.pettogether.domain.repository.CategoryCodeRepository
import javax.inject.Inject

class AreaCodeRepositoryImpl @Inject constructor(
    private val areaCodeService: AreaCodeService
) : AreaCodeRepository {
    override suspend fun getAreaCode(): AreaCodeResponse {
        return areaCodeService.getAreaCode()
    }
}