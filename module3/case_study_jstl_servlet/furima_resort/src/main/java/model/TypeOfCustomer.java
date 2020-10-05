package model;

public class TypeOfCustomer {
    private Integer idTypeOfCustomer;
    private String typeOfcustomer;

    public TypeOfCustomer(Integer idTypeOfCustomer, String typeOfcustomer) {
        this.idTypeOfCustomer = idTypeOfCustomer;
        this.typeOfcustomer = typeOfcustomer;
    }

    public Integer getIdTypeOfCustomer() {
        return idTypeOfCustomer;
    }

    public void setIdTypeOfCustomer(Integer idTypeOfCustomer) {
        this.idTypeOfCustomer = idTypeOfCustomer;
    }

    public String getTypeOfcustomer() {
        return typeOfcustomer;
    }

    public void setTypeOfcustomer(String typeOfcustomer) {
        this.typeOfcustomer = typeOfcustomer;
    }
}
