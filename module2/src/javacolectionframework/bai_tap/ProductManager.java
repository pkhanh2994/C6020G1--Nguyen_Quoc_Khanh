package javacolectionframework.bai_tap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager implements Comparator<Product> {
   static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Product> arrayPro = new ArrayList<>();

    public static void edit() {
        System.out.println("If you want to edit product information please enter the product id");
        int id = scanner.nextInt();
        scanner.skip("\\R");

        for (Product product : arrayPro) {
            if (id == product.getId()) {
                System.out.println("Name of product");
                String name = scanner.nextLine();

                System.out.println("Price of product");
                int price = scanner.nextInt();
                product.setName(name);
                product.setPrice(price);
                break;
            }
        }

    }

    public static String search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to search product information please enter the product name");
        String name = scanner.nextLine();
        for (Product product : arrayPro) {
            if (product.getName().equals(name))
                return product.toString();
        }
        return "No available";
    }

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the product information");
        System.out.println("Name of product");
        String name = scanner.nextLine();
        System.out.println("Id of product");
        int id = scanner.nextInt();
        System.out.println("Price of product");
        int price = scanner.nextInt();
        Product product = new Product();
        product.setName(name);
        product.setId(id);
        product.setPrice(price);
        arrayPro.add(product);

    }

    @Override
    public int compare(Product product1, Product product2) {
        if (product1.getPrice() > product2.getPrice()) {
            return 1;
        } else if (product1.getPrice() == product2.getPrice()) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void display() {
        for (Product product : arrayPro) {
            System.out.println("Name is: " + product.getName() + "\t" +
                    " Price is " + product.getPrice());
        }
    }

    public static void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of product to delete");
        int id = scanner.nextInt();
        arrayPro.removeIf(product -> id == product.getId());

    }


}
