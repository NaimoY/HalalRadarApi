package com.halalradar.api.services;

import com.halalradar.api.entities.Restaurant;
import com.halalradar.api.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // This tells Spring "this is a service class" – it holds business logic.
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    // The constructor – when the service is created, it gets the file cabinet (repository) to use
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // This method saves a restaurant in the database (file cabinet)
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant); // Just gives it to the repository to store
    }

    // This method finds all the restaurants in the database
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll(); // Tells the repository: "Bring me everything!"
    }

    // You can add more methods like update, delete, findById here later
}
