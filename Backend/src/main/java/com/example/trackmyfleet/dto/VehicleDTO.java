package com.example.trackmyfleet.dto;

import com.example.trackmyfleet.entity.VehicleStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Long id;
    @Column(nullable = false, unique = true)

    private String licensePlate;
    private String make;
    private String model;
    private Integer year;
    @Enumerated(EnumType.STRING)
    private VehicleStatus status;
    private Integer mileage;
}
