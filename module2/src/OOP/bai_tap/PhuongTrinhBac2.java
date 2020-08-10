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


}
