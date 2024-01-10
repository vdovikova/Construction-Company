package com.example.bccom.repo;

import com.example.bccom.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findByName(String name);
}
