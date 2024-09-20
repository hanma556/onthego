package com.onthego.onthego.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {
    private static final String API_KEY = "3b6d573dded982f8035b949b7a645104"; // OpenWeatherMap API 키

    private final RestTemplate restTemplate; // RestTemplate 인스턴스

    // 생성자 주입을 통해 RestTemplate 인스턴스를 초기화
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // 주어진 위치에 대한 날씨 정보를 가져오는 메서드
    public WeatherResponse getWeatherByLocation(String location) {
        // OpenWeatherMap API 요청 URL 생성
        String url = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/data/2.5/weather")
                .queryParam("q", location) // 쿼리 파라미터로 위치 추가
                .queryParam("appid", API_KEY) // API 키 추가
                .queryParam("units", "metric") // 섭씨 단위로 설정
                .toUriString(); // 최종 URL 생성

        // API 호출 및 응답을 WeatherResponse 객체로 변환
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        return response; // 응답 반환
    }
}
