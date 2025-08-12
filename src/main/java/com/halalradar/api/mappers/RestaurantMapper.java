package com.halalradar.api.mappers;


import com.halalradar.api.dtos.LocationDto;
import com.halalradar.api.dtos.RestaurantDto;
import com.halalradar.api.entities.Location;
import com.halalradar.api.entities.Restaurant;
import org.springframework.stereotype.Component;

@Component  // Makes this class a Spring managed bean so it can be injected wherever needed
public class RestaurantMapper {

    // Converts a RestaurantDto into a Restaurant entity (DTO -> Entity)
    public Restaurant mapToRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();

        // Set basic restaurant fields
        restaurant.setId(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());
        restaurant.setMainImage(restaurantDto.getMainImage());
        restaurant.setCreatedAt(restaurantDto.getCreatedAt());
        restaurant.setUpdatedAt(restaurantDto.getUpdatedAt());

        // Map locationDto to Location entity (if location is provided)
        if (restaurantDto.getLocationDto() != null) {
            Location location = new Location();
            location.setAddress(restaurantDto.getLocationDto().getAddress());
            location.setCity(restaurantDto.getLocationDto().getCity());
            location.setState(restaurantDto.getLocationDto().getState());
            location.setPostalCode(restaurantDto.getLocationDto().getPostalCode());
            location.setCountry(restaurantDto.getLocationDto().getCountry());
            location.setCreatedAt(restaurantDto.getLocationDto().getCreatedAt());
            location.setUpdatedAt(restaurantDto.getLocationDto().getUpdatedAt());

            // Set the two-way relationship
            location.setRestaurant(restaurant);
            restaurant.setLocation(location);
        }

        return restaurant;
    }

    // Converts a Restaurant entity into a RestaurantDto (Entity -> DTO)
    public RestaurantDto mapToRestaurantDto(Restaurant restaurant) {
        RestaurantDto dto = new RestaurantDto();

        // Set basic fields from the entity to the DTO
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setMainImage(restaurant.getMainImage());
        dto.setCreatedAt(restaurant.getCreatedAt());
        dto.setUpdatedAt(restaurant.getUpdatedAt());

        // Map Location entity to LocationDto (if it exists)
        if (restaurant.getLocation() != null) {
            LocationDto locationDto = new LocationDto();
            locationDto.setId(restaurant.getLocation().getId());

            // Convert restaurant ID to int (DTO uses int, entity uses Long)
            locationDto.setRestaurantId(restaurant.getId().intValue());

            locationDto.setAddress(restaurant.getLocation().getAddress());
            locationDto.setCity(restaurant.getLocation().getCity());
            locationDto.setState(restaurant.getLocation().getState());
            locationDto.setPostalCode(restaurant.getLocation().getPostalCode());
            locationDto.setCountry(restaurant.getLocation().getCountry());
            locationDto.setCreatedAt(restaurant.getLocation().getCreatedAt());
            locationDto.setUpdatedAt(restaurant.getLocation().getUpdatedAt());

            dto.setLocationDto(locationDto);
        }

        return dto;
    }
}