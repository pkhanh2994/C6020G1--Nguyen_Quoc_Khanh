package javacolectionframework.bai_tap;

public class ProductMain {
    public static void main(String[] args) {
        Product ferrari = new Product("Ferrari", 1, 700);
        Product lamborghini = new Product("Lamborghini", 2, 650);
        Product porsche = new Product("Porsche", 3, 400);
        Product mercedes = new Product("Mercedes", 4, 350);
        Product astonMartin = new Product("Aston Martin", 5, 500);
        ProductManager.arrayPro.add(ferrari);
        ProductManager.arrayPro.add(lamborghini);
        ProductManager.arrayPro.add(porsche);
        ProductManager.arrayPro.add(mercedes);
        ProductManager.arrayPro.add(astonMartin);
//        ProductManager.display();
//        ProductManager.addProduct();
//        ProductManager.display();
//        System.out.println(ProductManager.search());
//        ProductManager.removeProduct();
        ProductManager.display();
        ProductManager.edit();
        ProductManager.display();
//        ProductManager productManager = new ProductManager();
//        System.out.println("Product listing sorted by price in ascending order");
//        Collections.sort(ProductManager.arrayPro, productManager);
//        ProductManager.display();
//        System.out.println("--------------------------------------------------");
//        System.out.println("List of products sorted by descending price");
//        Collections.sort(ProductManager.arrayPro);
//        ProductManager.display();

    }
}
