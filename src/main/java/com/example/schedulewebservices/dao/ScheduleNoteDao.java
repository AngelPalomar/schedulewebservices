package com.example.schedulewebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schedulewebservices.models.ScheduleNote;

public interface ScheduleNoteDao extends JpaRepository<ScheduleNote, String> {

}
