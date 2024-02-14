package com.example.bccom.models;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "construction_company")
public class ConstructionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id", nullable = false)
    private Integer id;

    @Column(name = "com_login", nullable = false, length = 45)
    private String comLogin;

    @Column(name = "com_pass", nullable = false, length = 45)
    private String comPass;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "surname", nullable = false, length = 45)
    private String surname;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "com")
    private Set<Building> buildings = new LinkedHashSet<>();

    public Set<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComPass() {
        return comPass;
    }

    public void setComPass(String comPass) {
        this.comPass = comPass;
    }

    public String getComLogin() {
        return comLogin;
    }

    public void setComLogin(String comLogin) {
        this.comLogin = comLogin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}