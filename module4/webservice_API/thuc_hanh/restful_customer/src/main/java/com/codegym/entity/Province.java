package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name ="province")

public class Province {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
     private Long idProvince;
     private String name;

     @OneToMany(mappedBy = "province",cascade = CascadeType.ALL)
     List<Customer>customerList;

    public Province() {
    }

    public Long getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Long idProvince) {
        this.idProvince = idProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}