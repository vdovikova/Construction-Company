package com.example.bccom.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id", nullable = false)
    private Integer id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "use_date")
    private LocalDate useDate;

    @Column(name = "floor_plan")
    private byte[] floorPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "com_id")
    private ConstructionCompany com;

    @Column(name = "district", nullable = false, length = 45)
    private String district;

    @Column(name = "street", length = 100)
    private String street;

    @Column(name = "house_num", length = 45)
    private String houseNum;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public ConstructionCompany getCom() {
        return com;
    }

    public void setCom(ConstructionCompany com) {
        this.com = com;
    }

    public byte[] getFloorPlan() {
        return floorPlan;
    }

    public void setFloorPlan(byte[] floorPlan) {
        this.floorPlan = floorPlan;
    }

    public LocalDate getUseDate() {
        return useDate;
    }

    public void setUseDate(LocalDate useDate) {
        this.useDate = useDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}