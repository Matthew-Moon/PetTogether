package com.matthew.pettogether.domain.usecase

import com.matthew.pettogether.data.dto.response.AreaCodeResponse
import com.matthew.pettogether.data.dto.response.CategoryCodeResponse
import com.matthew.pettogether.domain.model.Area
import com.matthew.pettogether.domain.repository.AreaCodeRepository
import com.matthew.pettogether.domain.repository.CategoryCodeRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetAreaCodeUseCase @Inject constructor(
    private val areaCodeRepository: AreaCodeRepository
) {
    suspend operator fun invoke(): List<Area> {
        return areaCodeRepository.getAreaCode()
    }
}