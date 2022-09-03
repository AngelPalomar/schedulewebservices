package com.example.schedulewebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schedulewebservices.models.Service;

public interface ServiceDao extends JpaRepository<Service, String> {

}
