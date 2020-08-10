package OOP.bai_tap;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều dài cạnh thứ nhất:  ");
        double canh1 = scanner.nextDouble();
        System.out.println("Nhập chiều dài cạnh thứ 2:  ");
        double canh2 = scanner.nextDouble();
        System.out.println("Nhập chiều dài cạnh thứ 3:  ");
        double canh3 = scanner.nextDouble();
        System.out.println("Nhập màu sắc của tam giác ");
        scanner.nextLine();
        String mauSac = scanner.nextLine();
        System.out.println("filled or not filled( answer is true or fasle");
        boolean fill = scanner.nextBoolean();
        Triangle triangle1 = new Triangle(mauSac, fill, canh1, canh2, canh3);
        System.out.println(triangle1);

    }
}
