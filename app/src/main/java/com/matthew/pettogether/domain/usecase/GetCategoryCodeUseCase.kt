package com.matthew.pettogether.domain.usecase

import com.matthew.pettogether.domain.model.Category
import com.matthew.pettogether.domain.repository.CategoryCodeRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetCategoryCodeUseCase @Inject constructor(
    private val categoryCodeRepository: CategoryCodeRepository
) {
    suspend operator fun invoke(): List<Category> {
        return categoryCodeRepository.getCategoryCode()
    }
}