package com.matthew.pettogether.data.dto.response

import com.matthew.pettogether.data.dto.response.commons.Response

data class LocationBasedResponse(
    val response: Response<LocationItem>
)

data class LocationItem(
    val addr1: String,
    val addr2: String?,
    val areacode: String?,
    val contentid: String,
    val contenttypeid: String,
    val dist: String,
    val firstimage: String?,
    val firstimage2: String?,
    val mapx: String,
    val mapy: String,
    val tel: String?,
    val title: String
) 