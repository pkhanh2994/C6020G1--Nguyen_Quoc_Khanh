package com.codegym.entity.service;

import com.codegym.entity.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "service")
public class ServiceFrurama {
    @Id
    @Column(name = "service_id")
    @Pattern(regexp = "^DV"+"-"+"\\d{4}$",message = "Service ID must be follow this form: DV-XXXX. X is number from 0-9")
    private String service_id;
    @Column(name = "service_name")
    private String service_name;
    @Pattern(regexp ="^[1-9][\\d]*",message = "area must be number" )
    @Column(name ="service_area")
    private String service_area;
    @Column(name = "service_cost")
    @Pattern(regexp ="^[1-9][\\d]*",message = "cost must be number" )
    private String service_cost;
    @Column(name = "service_max_people")
    @Pattern(regexp ="^[1-9][\\d]*",message = "max people must be number" )
    private String service_max_people;
    @Column(name = "standard_room")
    private String standard_room;
    @Column(name = "description_other_convenience")
    private String description_other_convenience;
    @Column(name = "pool_area")
    private String pool_area;
    @Column(name = "number_of_floors")
    @Pattern(regexp = "^[1-9][\\d]*",message = "floor must be number")
    private String number_of_floors;
    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rent_type_id")
    private TypeOfRent typeOfRent;
    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "service_type_id")
    private TypeOfService typeOfService;
    @OneToMany(mappedBy = "serviceFrurama",cascade = CascadeType.ALL)
    private List<Contract>contractList;

    public ServiceFrurama() {
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_area() {
        return service_area;
    }

    public void setService_area(String service_area) {
        this.service_area = service_area;
    }

    public String getService_cost() {
        return service_cost;
    }

    public void setService_cost(String service_cost) {
        this.service_cost = service_cost;
    }

    public String getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(String service_max_people) {
        this.service_max_people = service_max_people;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public String getPool_area() {
        return pool_area;
    }

    public void setPool_area(String pool_area) {
        this.pool_area = pool_area;
    }

    public String getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(String number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public TypeOfRent getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(TypeOfRent typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(TypeOfService typeOfService) {
        this.typeOfService = typeOfService;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
