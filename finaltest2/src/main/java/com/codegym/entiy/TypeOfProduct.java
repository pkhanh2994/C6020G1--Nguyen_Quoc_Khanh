package com.codegym.entiy;

import javax.persistence.*;
import java.util.List;

@Entity(name = "typeOfProduct")
public class TypeOfProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeOfProduct;
    private String nameOfTypeOfProduct;
    @OneToMany(mappedBy = "typeOfProduct",cascade = CascadeType.ALL)
    private List<Product> productList;

    public TypeOfProduct() {
    }

    public Integer getIdTypeOfProduct() {
        return idTypeOfProduct;
    }

    public void setIdTypeOfProduct(Integer idTypeOfProduct) {
        this.idTypeOfProduct = idTypeOfProduct;
    }

    public String getNameOfTypeOfProduct() {
        return nameOfTypeOfProduct;
    }

    public void setNameOfTypeOfProduct(String nameOfTypeOfProduct) {
        this.nameOfTypeOfProduct = nameOfTypeOfProduct;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
