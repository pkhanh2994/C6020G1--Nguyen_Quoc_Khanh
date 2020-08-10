package OOP.bai_tap;

import java.util.Scanner;

public class TestHinhChuNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the width");
        double width1 = scanner.nextDouble();
        System.out.println("Enter the height");
        double height2 = scanner.nextDouble();
        LopHinhChuNhat hinhChuNhat = new LopHinhChuNhat();
        hinhChuNhat.setHeight(height2);
        hinhChuNhat.setWidth(width1);
        System.out.println(hinhChuNhat.display());
        System.out.println("The area is " + hinhChuNhat.getArea());
        System.out.println("The perimeter is " + hinhChuNhat.getPerimeter());

    }
}
