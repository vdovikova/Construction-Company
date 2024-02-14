package com.example.bccom.services;


import com.example.bccom.models.Building;
import com.example.bccom.repo.BuildingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private static Connection connection;

//    static {
//        try {
//            connection = DriverManager.getConnection("jdcb:mysql://localhost/buildingcatalog", "root", "1234");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    public List<Building> listBuildings(String name) {
        if (name != null) {
            return buildingRepository.findByName(name);
        } else {
            return buildingRepository.findAll();
        }
    }

    public void saveBuilding (Building building) throws SQLException {
        log.info("Saving new {}", building);
//        PreparedStatement preparedStatement =
//                connection.prepareStatement("INSERT INTO Building VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
//
//        preparedStatement.setInt(1, building.getId());
//        preparedStatement.setDate(2, Date.valueOf(building.getStartDate()));
//        preparedStatement.setDate(3, Date.valueOf(building.getEndDate()));
//        preparedStatement.setDate(4, Date.valueOf(building.getUseDate()));
//        preparedStatement.setInt(5, building.getCom().getId());
//        preparedStatement.setString(6, building.getDistrict());
//        preparedStatement.setString(7, building.getStreet());
//        preparedStatement.setString(8, building.getHouseNum());
//        preparedStatement.setString(9, building.getName());
//        preparedStatement.setInt(10, building.getLevels());
//        preparedStatement.setBlob(5, (Blob) building.getFloorPlan());
//
//        preparedStatement.executeUpdate();
        buildingRepository.save(building);
    }

    public void editBuilding (Building building, Integer id){
        buildingRepository.deleteById(id);
        buildingRepository.save(building);
    }

    public void deleteBuilding (Integer id){
        buildingRepository.deleteById(id);
    }

    public Building getBuildingById (Integer id){
        return buildingRepository.findById(Math.toIntExact(id)).orElse(null);
    }
}
