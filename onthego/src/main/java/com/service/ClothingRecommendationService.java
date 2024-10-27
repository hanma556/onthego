package com.onthego.onthego.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClothingRecommendationService {

    // 기온과 날씨에 따라 옷을 추천하는 메서드
    public List<String> recommendClothing(double temperature, String weatherCondition) {
        List<String> clothingRecommendations = new ArrayList<>();

        // 비 오는 날씨에 대한 추천
        if ("Rain".equalsIgnoreCase(weatherCondition) || "Rainy".equalsIgnoreCase(weatherCondition)) {
            clothingRecommendations.add("우비");
            return clothingRecommendations; // 비 오는 경우 즉시 반환
        }

        // 기온에 따른 추천
        if (temperature >= 28) {
            clothingRecommendations.add("민소매");
            clothingRecommendations.add("숏팬츠");
            clothingRecommendations.add("샌들");
        } else if (temperature >= 23) {
            clothingRecommendations.add("반팔");
            clothingRecommendations.add("반바지");
            clothingRecommendations.add("샌들");
        } else if (temperature >= 20) {
            clothingRecommendations.add("셔츠");
            clothingRecommendations.add("슬랙스");
            clothingRecommendations.add("얇은 가디건");
            clothingRecommendations.add("운동화");
        } else if (temperature >= 17) {
            clothingRecommendations.add("후드");
            clothingRecommendations.add("청바지");
            clothingRecommendations.add("바람막이");
            clothingRecommendations.add("운동화");
        } else if (temperature >= 12) {
            clothingRecommendations.add("니트");
            clothingRecommendations.add("가디건");
            clothingRecommendations.add("청바지");
            clothingRecommendations.add("스니커즈");
        } else if (temperature >= 9) {
            clothingRecommendations.add("니트");
            clothingRecommendations.add("트렌치코트");
            clothingRecommendations.add("기모 바지");
            clothingRecommendations.add("비니");
        } else if (temperature >= 5) {
            clothingRecommendations.add("기모 후드");
            clothingRecommendations.add("코트");
            clothingRecommendations.add("기모 바지");
            clothingRecommendations.add("어그 부츠");
        } else {
            clothingRecommendations.add("기모 후드");
            clothingRecommendations.add("패딩");
            clothingRecommendations.add("기모 바지");
            clothingRecommendations.add("목도리");
        }

        return clothingRecommendations; // 추천된 옷 목록 반환
    }
}
