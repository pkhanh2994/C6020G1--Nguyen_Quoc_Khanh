package OOP.bai_tap;

public class Circle {
    private double radius=1.0;
    private String color="red";
   public Circle(){

    }

    public  Circle(double radius){
       this.radius=radius;
    }
    protected double getRadius(){
       return this.radius;
    }
    protected String getColor(){
        return this.color;
    }
    public static class Test{
        public static void main(String[] args) {


        }
    }
}
