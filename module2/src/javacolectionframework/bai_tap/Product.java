package javacolectionframework.bai_tap;

public class Product implements Comparable<Product>  {
    private String name;
    private int id;
    private int price;

    public Product() {
    }

    public Product(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "name "+this.name+" price "+this.price+" id "+this.id;
    }
    @Override
    public int compareTo(Product product) {
        double checkPrice=this.getPrice()-product.getPrice();
       if (checkPrice<0) {
            return 1;
        } else if (checkPrice==0) {
            return 0;
        } else {
            return -1;
        }
    }
}

