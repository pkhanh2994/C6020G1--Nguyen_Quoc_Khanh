package OOP.bai_tap;

public class Circle2 {
    protected int radius;
    protected String color;
    protected final double PI=3.14;

    public Circle2(){

    }
    public Circle2(int radius,String color){
        this.radius=radius;
        this.color=color;
    }

    public int getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double dienTich(){
        return PI*Math.pow(radius,2);
    }
    @Override
    public String toString(){
        return "A Circle with radius="
                + getRadius()
                + ", with color "
                + getColor();
    }
}
