package com.example.trackmyfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    private Long id;
    private Long vehicleId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime timestamp;
}
