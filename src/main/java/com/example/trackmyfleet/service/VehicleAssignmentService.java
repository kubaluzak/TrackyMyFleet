package com.example.trackmyfleet.service;

import com.example.trackmyfleet.entity.Driver;
import com.example.trackmyfleet.entity.Vehicle;
import com.example.trackmyfleet.entity.VehicleAssignment;

import com.example.trackmyfleet.repostiory.DriverRepository;
import com.example.trackmyfleet.repostiory.VehicleAssignmentRepository;
import com.example.trackmyfleet.repostiory.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class VehicleAssignmentService {

    private VehicleAssignmentRepository vehicleAssignmentRepository;

    private VehicleRepository vehicleRepository;

    private DriverRepository driverRepository;

    public VehicleAssignment assignDriverToVehicle(Long vehicleId, Long driverId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + vehicleId));
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + driverId));

        VehicleAssignment assignment = new VehicleAssignment(null, vehicle, driver, LocalDateTime.now(), null);
        return vehicleAssignmentRepository.save(assignment);
    }

    public VehicleAssignment unassignDriverFromVehicle(Long assignmentId) {
        VehicleAssignment assignment = vehicleAssignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id: " + assignmentId));

        assignment.setUnassignedAt(LocalDateTime.now());
        return vehicleAssignmentRepository.save(assignment);
    }

    public List<VehicleAssignment> getAssignmentsByVehicleId(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + vehicleId));
        return vehicleAssignmentRepository.findByVehicle(vehicle);
    }
}
