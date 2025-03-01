package com.matthew.pettogether.domain.usecase

import com.matthew.pettogether.domain.model.ContentTypeId
import com.matthew.pettogether.domain.model.Location
import com.matthew.pettogether.domain.repository.LocationRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class GetLocationBasedListUseCaseTest {
    
    private lateinit var locationRepository: LocationRepository
    private lateinit var getLocationBasedListUseCase: GetLocationBasedListUseCase

    @Before
    fun setUp() {
        locationRepository = mockk()
        getLocationBasedListUseCase = GetLocationBasedListUseCase(locationRepository)
    }

    @Test
    fun `위치 기반 리스트 조회 성공시 Location 리스트 반환`() = runTest {
        // given
        val contentTypeId = ContentTypeId.ACCOMMODATION
        val mapX = 126.981611
        val mapY = 37.568477
        val radius = 50000
        
        val expectedLocations = listOf(
            Location(
                id = "1234",
                title = "테스트 숙소",
                address = "서울시 강남구",
                detailAddress = "테헤란로 123",
                distance = 1000.0,
                imageUrl = "http://test.com/image.jpg",
                thumbnailUrl = "http://test.com/thumbnail.jpg",
                latitude = 37.568477,
                longitude = 126.981611,
                tel = "02-1234-5678"
            )
        )

        coEvery { 
            locationRepository.getLocationBasedList(
                contentTypeId = contentTypeId,
                mapX = mapX,
                mapY = mapY,
                radius = radius
            )
        } returns expectedLocations

        // when
        val result = getLocationBasedListUseCase(
            contentTypeId = contentTypeId,
            mapX = mapX,
            mapY = mapY,
            radius = radius
        )

        // then
        println("테스트 결과: $result")  // 결과 출력
        result.forEach { location ->
            println("""
                Location 상세정보:
                - ID: ${location.id}
                - 제목: ${location.title}
                - 주소: ${location.address}
                - 상세주소: ${location.detailAddress}
                - 거리: ${location.distance}m
                - 위도: ${location.latitude}
                - 경도: ${location.longitude}
                - 전화번호: ${location.tel}
            """.trimIndent())
        }
        
        assertEquals(expectedLocations, result)
        coVerify(exactly = 1) { 
            locationRepository.getLocationBasedList(
                contentTypeId = contentTypeId,
                mapX = mapX,
                mapY = mapY,
                radius = radius
            )
        }
    }

    @Test
    fun `radius 파라미터 생략시 기본값 50000 사용`() = runTest {
        // given
        val contentTypeId = ContentTypeId.ACCOMMODATION
        val mapX = 126.981611
        val mapY = 37.568477
        val defaultRadius = 50000
        
        val emptyResult = emptyList<Location>()
        
        coEvery { 
            locationRepository.getLocationBasedList(
                contentTypeId = contentTypeId,
                mapX = mapX,
                mapY = mapY,
                radius = defaultRadius
            )
        } returns emptyResult

        // when
        val result = getLocationBasedListUseCase(
            contentTypeId = contentTypeId,
            mapX = mapX,
            mapY = mapY
        )

        // then
        println("기본 radius 테스트 결과: $result")
        println("결과 크기: ${result.size}")
        
        coVerify { 
            locationRepository.getLocationBasedList(
                contentTypeId = contentTypeId,
                mapX = mapX,
                mapY = mapY,
                radius = defaultRadius
            )
        }
    }

    @Test(expected = Exception::class)
    fun `Repository에서 예외 발생시 그대로 예외 전파`() = runTest {
        // given
        val contentTypeId = ContentTypeId.ACCOMMODATION
        val mapX = 126.981611
        val mapY = 37.568477
        
        val errorMessage = "네트워크 에러"
        
        coEvery { 
            locationRepository.getLocationBasedList(any(), any(), any(), any())
        } throws Exception(errorMessage)

        try {
            // when
            getLocationBasedListUseCase(
                contentTypeId = contentTypeId,
                mapX = mapX,
                mapY = mapY
            )
        } catch (e: Exception) {
            // then
            println("예외 발생 테스트: ${e.message}")
            throw e
        }
    }
} 