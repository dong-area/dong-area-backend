package com.cos.dong_area_backend.service;

import com.cos.dong_area_backend.entity.Alarm;
import com.cos.dong_area_backend.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlarmService {
    private final AlarmRepository alarmRepository;

    public void sendAlarm(String username, String target){
        Alarm alarm = Alarm.builder()
                .writer(username)
                .target(target)
                .build();
        alarmRepository.save(alarm);
    }
}
