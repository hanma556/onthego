package com.onthego.onthego.service;

import java.util.List;

// OpenWeatherMap API의 날씨 응답을 나타내는 클래스
public class WeatherResponse {
    private List<Weather> weather; // 날씨 정보를 담고 있는 리스트
    private Main main; // 기온 정보 담고 있는 객체

    // 날씨 정보 리스트 반환
    public List<Weather> getWeather() {
        return weather;
    }

    // 날씨 정보 리스트 설정
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    // 기온 정보 반환
    public Main getMain() {
        return main;
    }

    // 기온 정보 설정
    public void setMain(Main main) {
        this.main = main;
    }

    // 날씨 정보를 담고 있는 내부 클래스
    public static class Weather {
        private String description; // 날씨 설명

        // 날씨 설명 반환
        public String getDescription() {
            return description;
        }

        // 날씨 설명 설정
        public void setDescription(String description) {
            this.description = description;
        }
    }

    // 기온 정보를 담고 있는 내부 클래스
    public static class Main {
        private double temp; // 기온

        // 기온 반환
        public double getTemp() {
            return temp;
        }

        // 기온 설정
        public void setTemp(double temp) {
            this.temp = temp;
        }
    }
}
