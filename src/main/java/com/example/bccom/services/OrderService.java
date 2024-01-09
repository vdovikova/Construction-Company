package com.example.bccom.services;

import com.example.bccom.models.Order;
import com.example.bccom.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service

public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> listOrders(Integer id) {
        if (id != null) orderRepository.findById(id);
        return orderRepository.findAll();
    }

    public void saveOrder (Order order){
        log.info("Saving new {}", order);
        orderRepository.save(order);
    }

    public void deleteOrder (Long id){
        orderRepository.deleteById(id);
    }

    public Order getOrderById (Long id){
        return orderRepository.findById(id).orElse(null);
    }

}
