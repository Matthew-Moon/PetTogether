package com.matthew.pettogether.domain.model

data class Location(
    val id: String,
    val title: String,
    val address: String,
    val detailAddress: String?,
    val distance: Double,
    val imageUrl: String?,
    val thumbnailUrl: String?,
    val latitude: Double,
    val longitude: Double,
    val tel: String?
) 