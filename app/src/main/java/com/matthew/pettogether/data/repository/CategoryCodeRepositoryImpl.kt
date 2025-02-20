package com.matthew.pettogether.data.repository

import com.matthew.pettogether.data.dto.response.CategoryCodeItem
import com.matthew.pettogether.data.service.CategoryCodeService
import com.matthew.pettogether.domain.model.Category
import com.matthew.pettogether.domain.repository.CategoryCodeRepository
import javax.inject.Inject

class CategoryCodeRepositoryImpl @Inject constructor(
    private val categoryCodeService: CategoryCodeService
) : CategoryCodeRepository {
    override suspend fun getCategoryCode(): List<Category> =
        categoryCodeService.getCategoryCode()
            .response
            .body
            .items
            .item
            .map { it.toDomain() }

    private fun CategoryCodeItem.toDomain() = Category(
        code = code,
        name = name
    )
}