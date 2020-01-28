package com.autoparts.parts.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(name = "parts_for_maintenance",nullable = false, length = 100)
    private String partsForMaintenance;

    @Column(name = "engine_and_exhaust",nullable = false, length = 100)
    private String engineAndExhaust;

    @Column(name = "suspension_and_steering",nullable = false, length = 100)
    private String suspensionAndSteering;

    @Column(nullable = false, length = 100)
    private String gearbox;

    @Column(name = "cooling_and_heating_system",nullable = false, length = 100)
    private String coolingAndHeatingSystem;

    @Column(name = "body_parts",nullable = false, length = 100)
    private String bodyParts;

    @Column(nullable = false, length = 100)
    private String fluids;


}
