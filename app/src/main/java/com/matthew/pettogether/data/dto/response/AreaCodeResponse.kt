package com.matthew.pettogether.data.dto.response

import com.matthew.pettogether.data.dto.response.commons.Response

data class AreaCodeResponse(
    val response: Response<AreaCodeItem>
)

data class AreaCodeItem(
    val code: String,
    val name: String,
    val rnum: Int
)