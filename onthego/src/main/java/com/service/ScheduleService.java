package com.onthego.onthego.service;

import com.onthego.onthego.model.Schedule;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    private List<Schedule> schedules = new ArrayList<>(); // 일정 목록 저장

    // 일정 추가 메서드
    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    // 일정 목록 반환 메서드
    public List<Schedule> getSchedules() {
        return schedules;
    }

    // 특정 날짜의 과거 일정 조회 메서드
    public List<Schedule> getPastSchedules(String date) {
        List<Schedule> pastSchedules = new ArrayList<>();
        for (Schedule schedule : schedules) {
            if (schedule.getDate().equals(date)) {
                pastSchedules.add(schedule);
            }
        }
        return pastSchedules;
    }

    // 현재 활성 일정을 반환하는 메서드
    public List<Schedule> getActiveSchedules() {
        List<Schedule> activeSchedules = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for (Schedule schedule : schedules) {
            // startDate와 endDate 필드가 있어야 함
            if (schedule.getStartDate().isBefore(now) && schedule.getEndDate().isAfter(now)) {
                activeSchedules.add(schedule);
            }
        }
        return activeSchedules; // 활성 일정 목록 반환
    }
}
