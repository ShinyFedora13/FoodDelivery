package com.ust.Restaurant.service;

import com.ust.Restaurant.entity.Restaurant;
import com.ust.Restaurant.exception.RestaurantNotFoundException;
import com.ust.Restaurant.repository.RestaurantRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return (Restaurant) restaurantRepo.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        if (!restaurantRepo.existsById(id)) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        restaurant.setId(id);
        return (Restaurant) restaurantRepo.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        if (!restaurantRepo.existsById(id)) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        restaurantRepo.deleteById(id);
    }

    public Restaurant getRestaurantById(Long id) {
        return getRestaurantById(id);
    }

    public Restaurant saveRestaurant(@Valid Restaurant restaurant) {
        return restaurant;
    }
}


