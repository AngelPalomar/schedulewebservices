package com.example.schedulewebservices.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jet_services")
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "service_name")
    private String name;

    @Column(name = "service_description")
    private String description;
}
