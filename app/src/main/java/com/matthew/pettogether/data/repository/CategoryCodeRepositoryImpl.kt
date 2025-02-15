package com.matthew.pettogether.data.repository

import com.matthew.pettogether.data.dto.response.CategoryCodeResponse
import com.matthew.pettogether.data.service.CategoryCodeService
import com.matthew.pettogether.domain.repository.CategoryCodeRepository
import javax.inject.Inject

class CategoryCodeRepositoryImpl @Inject constructor(
    private val categoryCodeService: CategoryCodeService
) : CategoryCodeRepository {
    override suspend fun getCategoryCode(): CategoryCodeResponse {
        return categoryCodeService.getCategoryCode()
    }
}