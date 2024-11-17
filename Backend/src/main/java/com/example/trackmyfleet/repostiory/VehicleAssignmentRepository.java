package com.example.trackmyfleet.repostiory;

import com.example.trackmyfleet.entity.Vehicle;
import com.example.trackmyfleet.entity.VehicleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VehicleAssignmentRepository extends JpaRepository<VehicleAssignment,Long> {
    List<VehicleAssignment> findByVehicle(Vehicle vehicle);
}
