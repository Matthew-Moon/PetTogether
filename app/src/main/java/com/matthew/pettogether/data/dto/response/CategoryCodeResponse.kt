package com.matthew.pettogether.data.dto.response

import com.matthew.pettogether.data.dto.response.commons.Response

data class CategoryCodeResponse(
    val response: Response<CategoryCodeItem>
)

data class CategoryCodeItem(
    val code: String,
    val name: String,
    val rnum: Int
)