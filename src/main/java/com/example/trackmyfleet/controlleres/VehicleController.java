package com.example.trackmyfleet.controlleres;

import com.example.trackmyfleet.dto.VehicleDTO;
import com.example.trackmyfleet.entity.Vehicle;
import com.example.trackmyfleet.mappers.VehicleMapper;
import com.example.trackmyfleet.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/vehicles")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class VehicleController {

    private VehicleService vehicleService;
    private VehicleMapper vehicleMapper;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {

        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        List<VehicleDTO> vehicleDTOS = vehicles.stream()
                .map(vehicleMapper::toDTO)
                .toList();
        if (vehicles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vehicleDTOS);
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody Vehicle vehicle) {
        VehicleDTO vehicleDTO = vehicleMapper.toDTO(vehicle);
        vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok(vehicleDTO);
    }

    @GetMapping("/{licensePlate}")
    public ResponseEntity<VehicleDTO> getVehicleByLicensePlate(@PathVariable String licensePlate) {
        Vehicle vehicle = vehicleService.getVehicleByLicensePlate(licensePlate);
        VehicleDTO vehicleDTO = vehicleMapper.toDTO(vehicle);
        return ResponseEntity.ok(vehicleDTO);
    }
    @PatchMapping("/{licensePlate}")
    public ResponseEntity<VehicleDTO> updateVehicle(
            @PathVariable String licensePlate,
            @RequestBody VehicleDTO vehicleDTO) {
        Vehicle existingVehicle = vehicleService.getVehicleByLicensePlate(licensePlate);
        if (existingVehicle == null) {
            System.out.println("Vehice not found");
            return ResponseEntity.notFound().build();
        }
        vehicleMapper.updateVehicleFromDTO(vehicleDTO, existingVehicle);

        Vehicle updatedVehicle = vehicleService.saveVehicle(existingVehicle);
        VehicleDTO updatedVehicleDTO = vehicleMapper.toDTO(updatedVehicle);

        return ResponseEntity.ok(updatedVehicleDTO);
    }
}

