package com.example.trackmyfleet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String licensePlate;

    private String model;
    private String make;
    private Integer year;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    private Integer mileage;

}


