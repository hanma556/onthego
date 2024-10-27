package com.onthego.onthego.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreparationRecommendationService {

    // 기온과 날씨에 따라 준비물을 추천하는 메서드
    public List<String> recommendPreparationItems(double temperature, String weather) {
        List<String> preparationRecommendations = new ArrayList<>(); // 추천할 준비물 목록

        // 비 오는 날씨에 대한 추천
        if ("Rain".equalsIgnoreCase(weather) || "Rainy".equalsIgnoreCase(weather)) {
            preparationRecommendations.add("우산");
        }
        // 눈 오는 날씨에 대한 추천
        else if ("Snow".equalsIgnoreCase(weather) || "Snowy".equalsIgnoreCase(weather)) {
            preparationRecommendations.add("핫팩");
            preparationRecommendations.add("보온병");
        }

        // 기온에 따른 추천
        if (temperature >= 28) {
            preparationRecommendations.add("양산");
            preparationRecommendations.add("선크림");
        } else if (temperature >= 23) {
            preparationRecommendations.add("부채");
            preparationRecommendations.add("휴대용 선풍기");
        } else if (temperature >= 20) {
            preparationRecommendations.add("손수건");
        } else if (temperature >= 17) {
            preparationRecommendations.add("스카프");
        } else if (temperature >= 12) {
            preparationRecommendations.add("마스크");
        } else if (temperature >= 9) {
            preparationRecommendations.add("담요");
        } else if (temperature >= 5) {
            preparationRecommendations.add("핸드크림");
        } else {
            preparationRecommendations.add("핫팩");
        }

        return preparationRecommendations; // 추천된 준비물 목록 반환
    }
}
