package com.onthego.onthego.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClothingRecommendationService {

    // 날씨에 따라 옷을 추천하는 메서드
    public List<String> recommendClothing(String weather) {
        List<String> clothingRecommendations = new ArrayList<>();

        // 맑거나 화창한 날씨에 대한 추천
        if ("Clear".equalsIgnoreCase(weather) || "Sunny".equalsIgnoreCase(weather)) {
            clothingRecommendations.add("T-shirt");
            clothingRecommendations.add("Shorts");
            clothingRecommendations.add("Sandals");
        }
        // 비 오는 날씨에 대한 추천
        else if ("Rain".equalsIgnoreCase(weather) || "Rainy".equalsIgnoreCase(weather)) {
            clothingRecommendations.add("Waterproof jacket");
            clothingRecommendations.add("Comfortable pants");
        }
        // 구름 낀 날씨에 대한 추천
        else if ("Clouds".equalsIgnoreCase(weather) || "Cloudy".equalsIgnoreCase(weather)) {
            clothingRecommendations.add("Light jacket");
            clothingRecommendations.add("Long pants");
        }
        // 눈 오는 날씨에 대한 추천
        else if ("Snow".equalsIgnoreCase(weather) || "Snowy".equalsIgnoreCase(weather)) {
            clothingRecommendations.add("Winter coat");
            clothingRecommendations.add("Padded jacket");
        }
        // 기타 날씨에 대한 기본 추천
        else {
            clothingRecommendations.add("Appropriate clothing based on weather");
        }

        return clothingRecommendations; // 추천된 옷 목록 반환
    }
}
