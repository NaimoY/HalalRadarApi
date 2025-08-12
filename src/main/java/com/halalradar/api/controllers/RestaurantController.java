package com.halalradar.api.controllers;

import com.halalradar.api.dtos.RestaurantDto;
import com.halalradar.api.entities.Restaurant;
import com.halalradar.api.mappers.RestaurantMapper;
import com.halalradar.api.services.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Tells Spring: "Hey! This class will handle web/API requests"
@RequestMapping("/api/restaurants") // The path Postman or frontend will use to reach here
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    // The constructor – gives the receptionist access to the manager and translator
    public RestaurantController(RestaurantService restaurantService, RestaurantMapper restaurantMapper) {
        this.restaurantService = restaurantService;
        this.restaurantMapper = restaurantMapper;
    }

    //  This method handles POST requests – when someone wants to create a restaurant
    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto dto) {
        // Step 1: Turn the DTO (what the frontend gives) into an Entity (for saving)
        Restaurant restaurant = restaurantMapper.mapToRestaurant(dto);

        // Step 2: Ask the manager (service) to save the restaurant
        Restaurant saved = restaurantService.saveRestaurant(restaurant);

        // Step 3: Turn the saved restaurant back into a DTO for the frontend
        RestaurantDto responseDto = restaurantMapper.mapToRestaurantDto(saved);

        // Step 4: Return the result with status 200 OK
        return ResponseEntity.ok(responseDto);
    }

    // This method handles GET requests – when someone wants to see all restaurants
    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        // Step 1: Ask the manager to get all the restaurants
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();

        // Step 2: Use the translator to turn each restaurant into a DTO for the frontend
        List<RestaurantDto> dtos = restaurants.stream()
                .map(restaurantMapper::mapToRestaurantDto)
                .toList();

        // Step 3: Give the list back to Postman or the frontend
        return ResponseEntity.ok(dtos);
    }
}
