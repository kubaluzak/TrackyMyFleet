package com.example.trackmyfleet.mappers;

import com.example.trackmyfleet.dto.VehicleDTO;
import com.example.trackmyfleet.entity.Vehicle;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")

public interface VehicleMapper {
    VehicleDTO toDTO(Vehicle vehicle);
    Vehicle toEntity(VehicleDTO vehicleDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateVehicleFromDTO(VehicleDTO vehicleDTO, @MappingTarget Vehicle vehicle);
}
