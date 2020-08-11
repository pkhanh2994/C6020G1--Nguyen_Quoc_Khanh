package OOP.interfaceandabtrasct.thuc_hanh;

public class Circle {
    protected double radius = 1.0;
    protected String color = "red";
    protected boolean filled = true;


    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    protected double getRadius() {
        return this.radius;
    }

    protected String getColor() {
        return this.color;
    }

    public static class Test {
        public static void main(String[] args) {


        }
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + "with color " +
                getColor();
    }
}
