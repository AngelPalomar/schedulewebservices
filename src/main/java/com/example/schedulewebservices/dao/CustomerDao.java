package com.example.schedulewebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schedulewebservices.models.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {

}
