package com.onthego.onthego.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Schedule {
    private LocalDate date; // 날짜
    private String event; // 일정 내용
    private String weather; // 날씨 정보 추가
    private String priority; // 일정 우선순위 추가 (예: High, Medium, Low)
    private boolean reminder; // 알림 설정 추가
    private LocalDateTime alarmTime; // 알람 시간 추가

    public Schedule() {
    } // 기본 생성자

    public Schedule(LocalDate date, String event, String weather, String priority, boolean reminder,
            LocalDateTime alarmTime) {
        this.date = date;
        this.event = event;
        this.weather = weather; // 날씨 정보 초기화
        this.priority = priority; // 우선순위 초기화
        this.reminder = reminder; // 알림 설정 초기화
        this.alarmTime = alarmTime; // 알람 시간 초기화
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getWeather() {
        return weather; // 날씨 정보 반환
    }

    public void setWeather(String weather) {
        this.weather = weather; // 날씨 정보 설정
    }

    public String getPriority() {
        return priority; // 우선순위 반환
    }

    public void setPriority(String priority) {
        this.priority = priority; // 우선순위 설정
    }

    public boolean isReminder() {
        return reminder; // 알림 설정 반환
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder; // 알림 설정
    }

    public LocalDateTime getAlarmTime() {
        return alarmTime; // 알람 시간 반환
    }

    public void setAlarmTime(LocalDateTime alarmTime) {
        this.alarmTime = alarmTime; // 알람 시간 설정
    }
}
