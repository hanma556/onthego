package com.onthego.onthego.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.onthego.onthego.model.Schedule;

import java.time.ZoneId;

public class AlarmService {
    private Context context;

    public AlarmService(Context context) {
        this.context = context;
    }

    public void setAlarm(Schedule schedule) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra("event", schedule.getEvent());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        long alarmTimeMillis = schedule.getAlarmTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        // 알람 설정
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTimeMillis, pendingIntent);
    }
}
