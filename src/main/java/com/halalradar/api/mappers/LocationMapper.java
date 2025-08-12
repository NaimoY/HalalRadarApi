package com.halalradar.api.mappers;

import com.halalradar.api.dtos.LocationDto;
import com.halalradar.api.entities.Location;
import com.halalradar.api.entities.Restaurant;
import org.springframework.stereotype.Component;

@Component // allows Springboot to inject this mapper wherever needed
public class LocationMapper {

    // Converts a LocationDto into a Location entity (DTO -> Entity)
    public Location mapToLocation(LocationDto locationDto, Restaurant restaurant) {
        Location location = new Location();

        location.setAddress(locationDto.getAddress());
        location.setCity(locationDto.getCity());
        location.setState(locationDto.getState());
        location.setPostalCode(locationDto.getPostalCode());
        location.setCountry(locationDto.getCountry());
        location.setCreatedAt(locationDto.getCreatedAt());
        location.setUpdatedAt(locationDto.getUpdatedAt());

        // Set the two-way relationship if needed
        location.setRestaurant(restaurant);

        return location;
    }
    // Converts a Location entity into a LocationDto (Entity → DTO)
    public LocationDto mapToLocationDto(Location location) {
        LocationDto dto = new LocationDto();

        dto.setId(location.getId());
        dto.setRestaurantId(location.getRestaurant() != null ? location.getRestaurant().getId().intValue() : null);
        dto.setAddress(location.getAddress());
        dto.setCity(location.getCity());
        dto.setState(location.getState());
        dto.setPostalCode(location.getPostalCode());
        dto.setCountry(location.getCountry());
        dto.setCreatedAt(location.getCreatedAt());
        dto.setUpdatedAt(location.getUpdatedAt());

        return dto;
    }




}
