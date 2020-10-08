package model;

public class Category {
    private String categoryID;
    private String typeOfProduct;

    public Category(String categoryID, String typeOfProduct) {
        this.categoryID = categoryID;
        this.typeOfProduct = typeOfProduct;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }
}
