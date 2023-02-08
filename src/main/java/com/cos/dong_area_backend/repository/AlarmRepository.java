package com.cos.dong_area_backend.repository;

import com.cos.dong_area_backend.entity.Alarm;
import com.cos.dong_area_backend.service.AlarmService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm,Long> {
    public List<Alarm> findAllByTarget(String target);
}
