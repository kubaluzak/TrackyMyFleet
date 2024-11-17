package com.example.trackmyfleet.service;

import com.example.trackmyfleet.entity.Vehicle;
import com.example.trackmyfleet.repostiory.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {
    private VehicleRepository vehicleRepository;
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }
    public Vehicle getVehicleByLicensePlate(String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate)
                .orElse(null);
}}
