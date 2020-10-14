package model.customer;

public class TypeOfCustomer {
    private String idTypeOfCustomer;
    private String typeOfcustomer;

    public TypeOfCustomer(String idTypeOfCustomer, String typeOfcustomer) {
        this.idTypeOfCustomer = idTypeOfCustomer;
        this.typeOfcustomer = typeOfcustomer;
    }

    public String getIdTypeOfCustomer() {
        return idTypeOfCustomer;
    }

    public void setIdTypeOfCustomer(String idTypeOfCustomer) {
        this.idTypeOfCustomer = idTypeOfCustomer;
    }

    public String getTypeOfcustomer() {
        return typeOfcustomer;
    }

    public void setTypeOfcustomer(String typeOfcustomer) {
        this.typeOfcustomer = typeOfcustomer;
    }
}
