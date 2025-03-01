package com.matthew.pettogether.domain.usecase

import com.matthew.pettogether.domain.model.ContentTypeId
import com.matthew.pettogether.domain.model.Location
import com.matthew.pettogether.domain.repository.LocationRepository
import javax.inject.Inject

class GetLocationBasedListUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {
    suspend operator fun invoke(
        contentTypeId: ContentTypeId,
        mapX: Double,
        mapY: Double,
        radius: Int = 50000
    ): List<Location> = locationRepository.getLocationBasedList(
        contentTypeId = contentTypeId,
        mapX = mapX,
        mapY = mapY,
        radius = radius
    )
} 