package com.matthew.pettogether.data.di

import com.google.gson.GsonBuilder
import com.matthew.pettogether.data.network.CommonQueryInterceptor
import com.matthew.pettogether.data.network.LoggingInterceptor
import com.matthew.pettogether.data.service.CategoryCodeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://apis.data.go.kr/B551011/KorPetTourService/"

    @Provides
    @Singleton
    fun provideCommonQueryInterceptor(): CommonQueryInterceptor {
        return CommonQueryInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(commonQueryInterceptor: CommonQueryInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(commonQueryInterceptor)
            .addInterceptor(LoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .create()
        )
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
}