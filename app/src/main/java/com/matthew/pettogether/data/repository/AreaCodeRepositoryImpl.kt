package com.matthew.pettogether.data.repository

import com.matthew.pettogether.data.dto.response.AreaCodeItem
import com.matthew.pettogether.data.service.AreaCodeService
import com.matthew.pettogether.domain.model.Area
import com.matthew.pettogether.domain.repository.AreaCodeRepository
import javax.inject.Inject

class AreaCodeRepositoryImpl @Inject constructor(
    private val areaCodeService: AreaCodeService
) : AreaCodeRepository {
    override suspend fun getAreaCode(): List<Area> =
        areaCodeService.getAreaCode()
            .response
            .body
            .items
            .item
            .map { it.toDomain() }

    private fun AreaCodeItem.toDomain() = Area(
        code = code,
        name = name
    )
}