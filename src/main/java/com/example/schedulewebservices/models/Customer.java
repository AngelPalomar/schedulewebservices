package com.example.schedulewebservices.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jet_customers")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "customer_id")
    private String id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_website")
    private String website;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "customer_description")
    private String description;
}
