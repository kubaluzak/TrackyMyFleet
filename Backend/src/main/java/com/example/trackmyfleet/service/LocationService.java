package com.example.trackmyfleet.service;

import com.example.trackmyfleet.entity.Location;
import com.example.trackmyfleet.entity.Vehicle;
import com.example.trackmyfleet.repostiory.LocationRepository;
import com.example.trackmyfleet.repostiory.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService {

    private LocationRepository locationRepository;

    private VehicleRepository vehicleRepository;

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> getLocationsByVehicleId(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + vehicleId));
        return locationRepository.findByVehicle(vehicle);
    }

    public Location getLatestLocation(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + vehicleId));
        return locationRepository.findTopByVehicleOrderByTimestampDesc(vehicle)
                .orElseThrow(() -> new RuntimeException("No location found for vehicle id: " + vehicleId));
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
