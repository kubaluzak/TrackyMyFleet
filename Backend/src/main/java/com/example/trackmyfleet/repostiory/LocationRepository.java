package com.example.trackmyfleet.repostiory;

import com.example.trackmyfleet.entity.Location;
import com.example.trackmyfleet.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByVehicle(Vehicle vehicle);
    Optional<Location> findTopByVehicleOrderByTimestampDesc(Vehicle vehicle);

}
