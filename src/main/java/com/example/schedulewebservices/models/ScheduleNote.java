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
@Table(name = "jet_schedule_notes")
public class ScheduleNote implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "schedule_note_pk")
    private String notePk;

    @Column(name = "schedule_fk")
    private String scheduleFk;

    @Column(name = "schedule_note_description")
    private String noteDescription;

    @Column(name = "schedule_note_added_by")
    private String noteAddedBy;

    @Column(name = "schedule_note_added_date")
    private Date noteAddedDate;
}
