package com.onthego.onthego.controller;

import com.onthego.onthego.model.Schedule; // Schedule 모델 임포트
import com.onthego.onthego.service.ClothingRecommendationService;
import com.onthego.onthego.service.PreparationRecommendationService;
import com.onthego.onthego.service.WeatherResponse;
import com.onthego.onthego.service.WeatherService;
import com.onthego.onthego.service.ScheduleService; // ScheduleService 임포트
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private ClothingRecommendationService clothingRecommendationService;

    @Autowired
    private PreparationRecommendationService preparationRecommendationService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("hi")
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok("hello2");
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String location) {
        WeatherResponse response = weatherService.getWeatherByLocation(location);
        String weatherDescription = response.getWeather().get(0).getDescription();
        double temperature = response.getMain().getTemp();

        List<String> clothingRecommendations = clothingRecommendationService.recommendClothing(weatherDescription);
        List<String> preparationRecommendations = preparationRecommendationService
                .recommendPreparationItems(weatherDescription);

        return "Current weather: " + weatherDescription +
                ", Temperature: " + temperature + "°C" +
                "\nRecommended clothing: " + String.join(", ", clothingRecommendations) +
                "\nRecommended items to prepare: " + String.join(", ", preparationRecommendations);
    }

    // 일정 추가 메서드
    @PostMapping("/calendar/add")
    public ResponseEntity<String> addSchedule(@RequestBody Schedule schedule) {
        WeatherResponse weatherResponse = weatherService.getWeatherByLocation(schedule.getDate()); // 날짜에 따른 날씨 정보
        String weatherDescription = weatherResponse.getWeather().get(0).getDescription();

        // 스케줄에 날씨 정보 추가
        schedule.setWeather(weatherDescription);
        scheduleService.addSchedule(schedule);

        return ResponseEntity.status(201).body("일정이 추가되었습니다.");
    }

    // 일정 목록 가져오기
    @GetMapping("/calendar/schedules")
    public List<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    // 활성 일정 가져오기
    @GetMapping("/calendar/schedules/active")
    public List<Schedule> getActiveSchedules() {
        return scheduleService.getActiveSchedules();
    }

    // 여기부터 4개 옮겨
    // 위치 허용 처리
    @PostMapping("/permissions/location/allow")
    public ResponseEntity<String> allowLocation() {
        // 위치 허용 로직 추가
        return ResponseEntity.ok("위치 허용됨.");
    }

    // 위치 거부 처리
    @PostMapping("/permissions/location/deny")
    public ResponseEntity<String> denyLocation() {
        // 거부 시 휴대폰 설정 어플로 안내하는 로직 추가
        return ResponseEntity.ok("위치 권한이 거부되었습니다. 설정에서 허용해주세요.");
    }

    // 알람 허용 처리
    @PostMapping("/permissions/alarm/allow")
    public ResponseEntity<String> allowAlarm() {
        // 알람 허용 로직 추가
        return ResponseEntity.ok("알람 허용됨.");
    }

    // 알람 거부 처리
    @PostMapping("/permissions/alarm/deny")
    public ResponseEntity<String> denyAlarm() {
        // 거부 시 휴대폰 설정 어플로 안내하는 로직 추가
        return ResponseEntity.ok("알람 권한이 거부되었습니다. 설정에서 허용해주세요.");
    }
}
