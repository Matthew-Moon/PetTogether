package com.matthew.pettogether.data.di

import com.matthew.pettogether.data.repository.CategoryCodeRepositoryImpl
import com.matthew.pettogether.domain.repository.CategoryCodeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCategoryCodeRepository(
        categoryCodeRepositoryImpl: CategoryCodeRepositoryImpl
    ): CategoryCodeRepository

//    @Binds
//    @Singleton
//    abstract fun bindAreaCodeRepository(
//        areaCodeRepositoryImpl: AreaCodeRepositoryImpl
//    ): AreaCodeRepository
} 