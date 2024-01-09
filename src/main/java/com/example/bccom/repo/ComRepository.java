package com.example.bccom.repo;

import com.example.bccom.models.ConstructionCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComRepository extends JpaRepository<ConstructionCompany, Integer> {
    List<ConstructionCompany> findBySurname(String surname);
}