package OOP.interfaceandabtrasct.bai_tap;

public class Square2 extends Rectangle implements Colorable {
    public Square2() {
    }

    public Square2(double side) {
        super(side, side);
    }

    public Square2(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString()
                +" Diện tích là : "+getPerimeter();
    }

    @Override
    public void howToColorable() {
        System.out.println("Color all four sides");
    }
}
