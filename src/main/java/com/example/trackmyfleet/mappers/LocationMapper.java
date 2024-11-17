package com.example.trackmyfleet.mappers;

import com.example.trackmyfleet.dto.LocationDTO;
import com.example.trackmyfleet.entity.Location;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mapping(target = "vehicleId", source = "vehicle.id")
    LocationDTO toDTO(Location location);

    @Mapping(target = "vehicle.id", source = "vehicleId")
    Location toEntity(LocationDTO locationDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateLocationFromDTO(LocationDTO locationDTO, @MappingTarget Location location);
}
