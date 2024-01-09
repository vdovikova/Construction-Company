package com.example.bccom.services;


import com.example.bccom.models.Building;
import com.example.bccom.repo.BuildingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    public List<Building> listBuildings(String district) {
        if (district != null) buildingRepository.findByDistrict(district);
        return buildingRepository.findAll();
    }

    public void saveBuilding (Building building){
        log.info("Saving new {}", building);
        buildingRepository.save(building);
    }

    public void editBuilding (Building building, Integer id){
        buildingRepository.deleteById(id);
        building.setId(id);
        buildingRepository.save(building);
    }

    public void deleteBuilding (Integer id){
        buildingRepository.deleteById(id);
    }

    public Building getBuildingById (Integer id){
        return buildingRepository.findById(Math.toIntExact(id)).orElse(null);
    }

}
