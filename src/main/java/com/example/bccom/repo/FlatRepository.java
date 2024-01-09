package com.example.bccom.repo;

import com.example.bccom.models.Flat;
import com.example.bccom.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Long> {
    List<Flat> findByBuilding(Building building);
}