package OOP.bai_tap;

import java.util.Scanner;

public class TestPTBac2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập a");
            double a1 = scanner.nextDouble();
            System.out.println("Nhập b");
            double b1 = scanner.nextDouble();
            System.out.println("nhập c");
            double c1 = scanner.nextDouble();
            PhuongTrinhBac2 phuongTrinhBac2 = new PhuongTrinhBac2(a1, b1, c1);
            System.out.println("Delta của phương trình là: "+phuongTrinhBac2.getDiscriminant());
            if (phuongTrinhBac2.getDiscriminant() > 0) {
                System.out.println("Nghiệm thứ nhất của phương trình là: " + phuongTrinhBac2.getRoot1());
                System.out.println("Nghiệm thứ hai của phương trình là: " + phuongTrinhBac2.getRoot2());
            } else if (phuongTrinhBac2.getDiscriminant() == 0) {
                System.out.println("Phương trình có nghiệm kép là: " + phuongTrinhBac2.getRoot3());
            } else
                System.out.println(phuongTrinhBac2.display());

        }
}
