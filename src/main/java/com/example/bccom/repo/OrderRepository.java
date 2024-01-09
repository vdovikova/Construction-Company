package com.example.bccom.repo;

import com.example.bccom.models.Building;
import com.example.bccom.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Building> findById(int id);
}
