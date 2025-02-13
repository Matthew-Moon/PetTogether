package com.matthew.pettogether.domain.model

enum class ContentTypeId(
    val id: Int,
    val description: String
) {
    TOURIST_SPOT(12, "관광지"),
    CULTURAL_FACILITY(14, "문화시설"),
    FESTIVAL_EVENT(15, "축제공연행사"),
    TRAVEL_COURSE(25, "여행코스"),
    LEISURE_SPORTS(28, "레포츠"),
    ACCOMMODATION(32, "숙박"),
    SHOPPING(38, "쇼핑"),
    RESTAURANT(39, "음식점");

    companion object {
        // ID로 ContentTypeId 찾기
        fun findById(id: Int): ContentTypeId? {
            return entries.find { it.id == id }
        }

        // 설명으로 ContentTypeId 찾기
        fun findByDescription(description: String): ContentTypeId? {
            return entries.find { it.description == description }
        }

        // 모든 타입의 정보를 Map으로 반환
        fun getAllTypesMap(): Map<Int, String> {
            return entries.associate { it.id to it.description }
        }

        // 모든 타입의 ID 목록 반환
        fun getAllTypeIds(): List<Int> {
            return entries.map { it.id }
        }

        // 모든 타입의 설명 목록 반환
        fun getAllDescriptions(): List<String> {
            return entries.map { it.description }
        }
    }

    // 현재 타입이 관광 관련 타입인지 확인
    fun isTourismType(): Boolean {
        return this in listOf(TOURIST_SPOT, CULTURAL_FACILITY, FESTIVAL_EVENT, TRAVEL_COURSE)
    }

    // 현재 타입이 편의시설 관련 타입인지 확인
    fun isAmenityType(): Boolean {
        return this in listOf(ACCOMMODATION, SHOPPING, RESTAURANT)
    }
}