package com.example.trackmyfleet.controlleres;

import com.example.trackmyfleet.dto.LocationDTO;
import com.example.trackmyfleet.entity.Location;
import com.example.trackmyfleet.mappers.LocationMapper;
import com.example.trackmyfleet.service.LocationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/locations")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class LocationController {

    private final LocationService locationService;
    private final LocationMapper locationMapper;



    @GetMapping("/latest/{id}")
    public ResponseEntity<LocationDTO> getLatestLocationById(@PathVariable Long id) {
        Optional<Location> location = Optional.ofNullable(locationService.getLatestLocation(id));
        Location location1 = location.get();
        LocationDTO locationDTO = locationMapper.toDTO(location1);
        return ResponseEntity.ok(locationDTO);
    }

}

