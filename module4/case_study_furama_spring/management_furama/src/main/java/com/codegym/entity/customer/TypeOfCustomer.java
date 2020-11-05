package com.codegym.entity.customer;

import javax.persistence.*;
import java.util.List;

@Entity(name="customer_type")
public class TypeOfCustomer {
    @Id
    @Column(name="customer_type_id",nullable = false)
    private String idTypeOfCustomer;
    @Column(name = "customer_type_name",nullable = false)
    private String nameTypeOfCustomer;

    @OneToMany(mappedBy = "typeOfCustomer",cascade = CascadeType.ALL)
    private List<Customer> customerList;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public TypeOfCustomer() {
    }

    public TypeOfCustomer(String idTypeOfCustomer, String nameTypeOfCustomer) {
        this.idTypeOfCustomer = idTypeOfCustomer;
        this.nameTypeOfCustomer = nameTypeOfCustomer;
    }

    public String getIdTypeOfCustomer() {
        return idTypeOfCustomer;
    }

    public void setIdTypeOfCustomer(String idTypeOfCustomer) {
        this.idTypeOfCustomer = idTypeOfCustomer;
    }

    public String getNameTypeOfCustomer() {
        return nameTypeOfCustomer;
    }

    public void setNameTypeOfCustomer(String nameTypeOfCustomer) {
        this.nameTypeOfCustomer = nameTypeOfCustomer;
    }
}
