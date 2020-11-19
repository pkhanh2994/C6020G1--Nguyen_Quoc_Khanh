package com.codegym.entity.service;

import javax.persistence.*;
import java.util.List;

@Entity(name = "service_type")
public class TypeOfService {
    @Id
    @Column(name = "service_type_id")
    private String service_type_id;
    @Column(name = "service_type_name")
    private String service_type_name;
    @OneToMany(mappedBy = "typeOfService",cascade = CascadeType.ALL)
    private List<ServiceFrurama> serviceFruramaList;

    public TypeOfService() {
    }

    public String getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(String service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getService_type_name() {
        return service_type_name;
    }

    public void setService_type_name(String service_type_name) {
        this.service_type_name = service_type_name;
    }

    public List<ServiceFrurama> getServiceFruramaList() {
        return serviceFruramaList;
    }

    public void setServiceFruramaList(List<ServiceFrurama> serviceFruramaList) {
        this.serviceFruramaList = serviceFruramaList;
    }
}
