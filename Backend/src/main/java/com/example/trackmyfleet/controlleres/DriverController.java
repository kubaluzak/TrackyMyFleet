package com.example.trackmyfleet.controlleres;

import com.example.trackmyfleet.dto.DriverDTO;
import com.example.trackmyfleet.entity.Driver;
import com.example.trackmyfleet.mappers.DriverMapper;
import com.example.trackmyfleet.service.DriverService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/drivers")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DriverController {

    private final DriverService driverService;
    private final DriverMapper driverMapper;

    @GetMapping
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        List<DriverDTO> driverDTOS = drivers.stream()
                .map(driverMapper::toDTO)
                .toList();

        if (drivers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(driverDTOS);
    }

    @PostMapping("/add")
    public ResponseEntity<DriverDTO> createDriver(@RequestBody DriverDTO driverDTO) {
        Driver driver = driverMapper.toEntity(driverDTO);
        Driver savedDriver = driverService.saveDriver(driver);
        DriverDTO savedDriverDTO = driverMapper.toDTO(savedDriver);

        return ResponseEntity.ok(savedDriverDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDTO> getDriverById(@PathVariable Long id) {
        Driver driver = driverService.getDriverByID(id);
        if (driver == null) {
            return ResponseEntity.notFound().build();
        }

        DriverDTO driverDTO = driverMapper.toDTO(driver);
        return ResponseEntity.ok(driverDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DriverDTO> updateDriver(
            @PathVariable Long id,
            @RequestBody DriverDTO driverDTO) {

        Driver existingDriver = driverService.getDriverByID(id);
        if (existingDriver == null) {
            return ResponseEntity.notFound().build();
        }

        driverMapper.updateDriverFromDTO(driverDTO, existingDriver);
        Driver updatedDriver = driverService.saveDriver(existingDriver);
        DriverDTO updatedDriverDTO = driverMapper.toDTO(updatedDriver);

        return ResponseEntity.ok(updatedDriverDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}
