package com.example.trackmyfleet.mappers;

import com.example.trackmyfleet.dto.DriverDTO;
import com.example.trackmyfleet.entity.Driver;
import org.mapstruct.*;

@Mapper(componentModel = "spring")

public interface DriverMapper {
    DriverDTO toDTO(Driver driver);
    Driver toEntity(DriverDTO driverDTO);
    @Mapping(target = "id", ignore = true)
    void updateDriverFromDTO(DriverDTO driverDTO, @MappingTarget Driver driver);
}
