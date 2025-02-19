package com.matthew.pettogether.domain.repository

import com.matthew.pettogether.domain.model.Category

interface CategoryCodeRepository {
    suspend fun getCategoryCode(): List<Category>
}