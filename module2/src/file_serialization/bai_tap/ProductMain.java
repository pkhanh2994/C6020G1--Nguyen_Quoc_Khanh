package file_serialization.bai_tap;

import java.io.IOException;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            boolean check=true;
            do {
                System.out.println("Menu: \n1.Add product\n2.Search\n3.Display\n0.Exit");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        ProductManager.addProduct();
                        break;
                    case 2:
                        ProductManager.search();
                        break;
                    case 3:
                        ProductManager.display();
                        break;
                    case 0:
                        check=false;
                        break;
                }
            }
            while (check);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
