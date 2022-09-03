package com.example.schedulewebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schedulewebservices.models.ServiceSchedule;

public interface ServiceScheduleDao extends JpaRepository<ServiceSchedule, String> {

}
