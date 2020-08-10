package OOP.bai_tap;

public class Cylinder extends Circle2{
    public int height;
    public Cylinder(){

    }
    public Cylinder(int radius,String color, int height){
        super(radius,color);
        this.height=height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public double theTich(){
//        dienTich();
        return dienTich()*height;
    }
    @Override
    public String toString(){
        return "A Cylinder with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }
}
