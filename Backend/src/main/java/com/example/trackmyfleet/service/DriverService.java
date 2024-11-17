package com.example.trackmyfleet.service;

import com.example.trackmyfleet.entity.Driver;
import com.example.trackmyfleet.repostiory.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DriverService {

    private DriverRepository driverRepository;
    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver getDriverByID(Long id) {
        return driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }
    public void deleteDriver(Long id) {
        if (driverRepository.existsById(id)) {
            driverRepository.deleteById(id);
        } else {
            throw new RuntimeException("Driver not found");
        }
    }
}
