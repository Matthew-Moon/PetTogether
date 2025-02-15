package com.matthew.pettogether.data.di

import com.matthew.pettogether.data.service.CategoryCodeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideCategoryCodeService(retrofit: Retrofit): CategoryCodeService {
        return retrofit.create(CategoryCodeService::class.java)
    }
} 