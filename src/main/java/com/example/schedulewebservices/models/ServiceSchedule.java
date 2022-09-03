package com.example.schedulewebservices.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jet_services_schedule")
public class ServiceSchedule implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "schedule_id")
    private String id;

    @Column(name = "schedule_customer_fk")
    private String customerFk;

    @Column(name = "service_fk")
    private String serviceFk;

    @Column(name = "schedule_status")
    private String status;

    @Column(name = "schedule_description")
    private String description;

    @Column(name = "schedule_date")
    private Date date;

    @Column(name = "schedule_added_by")
    private String addedBy;

    @Column(name = "schedule_added_date")
    private Date addedDate;
}
