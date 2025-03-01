package com.matthew.pettogether.data.repository

import com.matthew.pettogether.data.dto.response.LocationItem
import com.matthew.pettogether.data.service.LocationBasedService
import com.matthew.pettogether.domain.model.ContentTypeId
import com.matthew.pettogether.domain.model.Location
import com.matthew.pettogether.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationBasedService: LocationBasedService
) : LocationRepository {
    
    override suspend fun getLocationBasedList(
        contentTypeId: ContentTypeId,
        mapX: Double,
        mapY: Double,
        radius: Int
    ): List<Location> = locationBasedService.getLocationBasedList(
        contentTypeId = contentTypeId.id,
        mapX = mapX,
        mapY = mapY,
        radius = radius
    ).response.body.items.item.map { it.toDomain() }
    
    private fun LocationItem.toDomain() = Location(
        id = contentid,
        title = title,
        address = addr1,
        detailAddress = addr2,
        distance = dist.toDoubleOrNull() ?: 0.0,
        imageUrl = firstimage,
        thumbnailUrl = firstimage2,
        latitude = mapy.toDoubleOrNull() ?: 0.0,
        longitude = mapx.toDoubleOrNull() ?: 0.0,
        tel = tel
    )
} 