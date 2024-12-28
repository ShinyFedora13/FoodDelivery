package com.ust.Order.service;

import com.ust.Order.entity.Order;
import com.ust.Order.entity.OrderItem;
import com.ust.Order.exception.ItemNotAvailableException;
import com.ust.Order.repository.OrderRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrderService {

    @Autowired
    private OrderRepo repository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Order placeOrder(Order order) {
        // Validate restaurant existence
        webClientBuilder.build()
                .get()
                .uri("http://restaurant-service/api/restaurants/" + order.getRestaurantId())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return repository.save(order);
    }

    public Order createOrder(@Valid Order order) {
        return order;
    }
}
