package OOP.bai_tap;

public class Triangle extends Shape {
    private double size1 = 1.0;
    private double size2 = 1.0;
    private double size3 = 1.0;

    public Triangle() {
        this("red", true, 1.0, 1.0, 1.0);

    }

    public Triangle(String color, boolean filled, double size1, double size2, double size3) {
        super(color, filled);
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
    }

    public double getSize1() {
        return size1;
    }

    public double getSize2() {
        return size2;
    }

    public double getSize3() {
        return size3;
    }

    public void setSize1(double size1) {
        this.size1 = size1;
    }

    public void setSize2(double size2) {
        this.size2 = size2;
    }

    public void setSize3(double size3) {
        this.size3 = size3;
    }

    public double chuVi() {
        return (size1 + size2 + size3);
    }

    public double dienTich() {
        return Math.sqrt(chuVi() * ((chuVi() - size1) * (chuVi() - size2) * (chuVi() - size3)));
    }

    @Override
    public String toString() {
        return "Ba cạnh của tam giác là: " +
                " cạnh thứ nhất: " + getSize1() +
                " cạnh thứ 2: " + getSize2() +
                " cạnh thứ 3: " + getSize3() +
                " chu vi của tam giác là: " + chuVi() +
                " diện tích của tam giác là: " + dienTich() +
                " là lớp con của " + super.toString();


    }
}
