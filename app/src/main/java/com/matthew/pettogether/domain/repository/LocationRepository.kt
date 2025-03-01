package com.matthew.pettogether.domain.repository

import com.matthew.pettogether.domain.model.ContentTypeId
import com.matthew.pettogether.domain.model.Location

interface LocationRepository {
    suspend fun getLocationBasedList(
        contentTypeId: ContentTypeId,
        mapX: Double,
        mapY: Double,
        radius: Int
    ): List<Location>
}

