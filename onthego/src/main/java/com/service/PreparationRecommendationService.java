package com.onthego.onthego.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreparationRecommendationService {

    // 날씨에 따라 준비물을 추천하는 메서드
    public List<String> recommendPreparationItems(String weather) {
        List<String> preparationRecommendations = new ArrayList<>(); // 추천할 준비물 목록

        // 맑거나 화창한 날씨에 대한 추천
        if ("Clear".equalsIgnoreCase(weather) || "Sunny".equalsIgnoreCase(weather)) {
            preparationRecommendations.add("Sunglasses"); // 선글라스
            preparationRecommendations.add("Water bottle"); // 물병
            preparationRecommendations.add("Sunscreen"); // 자외선 차단제
            preparationRecommendations.add("Hat"); // 모자
        }
        // 비 오는 날씨에 대한 추천
        else if ("Rain".equalsIgnoreCase(weather) || "Rainy".equalsIgnoreCase(weather)) {
            preparationRecommendations.add("Umbrella"); // 우산
            preparationRecommendations.add("Waterproof bag"); // 방수 가방
            preparationRecommendations.add("Plastic bags"); // 비닐 봉지
        }
        // 구름 낀 날씨에 대한 추천
        else if ("Clouds".equalsIgnoreCase(weather) || "Cloudy".equalsIgnoreCase(weather)) {
            preparationRecommendations.add("Light backpack"); // 가벼운 배낭
            preparationRecommendations.add("Portable charger"); // 휴대용 충전기
        }
        // 눈 오는 날씨에 대한 추천
        else if ("Snow".equalsIgnoreCase(weather) || "Snowy".equalsIgnoreCase(weather)) {
            preparationRecommendations.add("Snow shovel"); // 눈삽
            preparationRecommendations.add("Ice scraper"); // 얼음 긁개
            preparationRecommendations.add("Warm gloves"); // 따뜻한 장갑
            preparationRecommendations.add("Thermos"); // 보온병
        }
        // 기타 날씨에 대한 기본 추천
        else {
            preparationRecommendations.add("Items based on the weather"); // 날씨에 따라 필요한 물품
        }

        return preparationRecommendations; // 추천된 준비물 목록 반환
    }
}
