package com.codegym.entity.service;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;


@Entity(name = "rent_type")
public class TypeOfRent {
    @Id
    @Column(name = "rent_type_id")
    private String rent_type_id;
    @Column(name = "rent_type_name")
    private String rent_type_name;
    @Column(name = "rent_type_cost")

    private String rent_type_cost;
    @OneToMany(mappedBy = "typeOfRent", cascade = CascadeType.ALL)
    private List<ServiceFrurama> serviceFruramaList;


    public TypeOfRent(){

    }

    public String getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(String rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getRent_type_name() {
        return rent_type_name;
    }

    public void setRent_type_name(String rent_type_name) {
        this.rent_type_name = rent_type_name;
    }

    public String getRent_type_cost() {
        return rent_type_cost;
    }

    public void setRent_type_cost(String rent_type_cost) {
        this.rent_type_cost = rent_type_cost;
    }

    public List<ServiceFrurama> getServiceFruramaList() {
        return serviceFruramaList;
    }

    public void setServiceFruramaList(List<ServiceFrurama> serviceFruramaList) {
        this.serviceFruramaList = serviceFruramaList;
    }
}