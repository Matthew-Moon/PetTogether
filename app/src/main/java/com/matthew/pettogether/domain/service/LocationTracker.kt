package com.matthew.pettogether.domain.service

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
    
    data class Location(
        val latitude: Double,
        val longitude: Double
    )
} 