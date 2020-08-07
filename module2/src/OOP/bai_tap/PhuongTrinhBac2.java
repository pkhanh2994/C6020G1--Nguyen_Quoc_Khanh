package OOP.bai_tap;

import java.util.Scanner;

public class PhuongTrinhBac2 {
    private double a;
    private double b;
    private double c;

    public PhuongTrinhBac2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return (Math.pow(this.b, 2) - (4 * this.a * this.c));
    }

    public double getRoot1() {

        return ((-this.b + Math.sqrt(Math.pow(this.b, 2) - (4 * this.a * this.c))) / 2 * this.a);
    }

    public double getRoot2() {

        return ((-this.b - Math.sqrt(Math.pow(this.b, 2) - (4 * this.a * this.c))) / 2 * this.a);
    }

    public double getRoot3() {

        return (-this.b / 2 * this.a);
    }

    public String display() {
        return "Phương trình vô nghiệm";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a");
        double a1 = scanner.nextDouble();
        System.out.println("Nhập b");
        double b1 = scanner.nextDouble();
        System.out.println("nhập c");
        double c1 = scanner.nextDouble();
        PhuongTrinhBac2 phuongTrinhBac2 = new PhuongTrinhBac2(a1, b1, c1);
        phuongTrinhBac2.getA();
        phuongTrinhBac2.getB();
        phuongTrinhBac2.getC();
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
