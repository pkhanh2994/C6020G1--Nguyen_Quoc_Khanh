package file_serialization.bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {

    public static ArrayList<Product> listProduct = new ArrayList<>();

    public static void addProduct() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the product information");
        System.out.println("Id of product");
        int id = scanner.nextInt();
        scanner.skip("\\R");
        System.out.println("Name of product");
        String name = scanner.nextLine();
        System.out.println("Manufacturer of product");
        String manufacturer = scanner.nextLine();
        System.out.println("Price of product");
        int price = scanner.nextInt();
        scanner.skip("\\R");
        System.out.println("other descriptions");
        String otherDescriptions = scanner.nextLine();

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setManufacturer(manufacturer);
        product.setPrice(price);
        product.setOtherDescriptions(otherDescriptions);
        listProduct.add(product);
        writeBinaryFile();

    }

    public static void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to search product information please enter the product name and id");
        System.out.println("Enter the product name");
        String name = scanner.nextLine();
        System.out.println("Enter the product id");
        int id = scanner.nextInt();

        readBinaryfile();
        boolean check=true;
        for (Product product : listProduct) {
            if (product.getName().equals(name) && id == product.getId()) {
                check=false;
                System.out.println(product.toString());

            }
        }
        if(check){
            System.out.println("The product does not exist");

        }
    }


    public static void display() {
        readBinaryfile();
        for (Product product : listProduct) {
            System.out.println(product);
        }

    }

    public static void writeBinaryFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Product.csv");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        try {
            outputStream.writeObject(listProduct);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinaryfile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("Product.csv");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listProduct = (ArrayList<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}