package OOP.interfaceandabtrasct.bai_tap;
public class CircleTest {
    public static void main(String[] args) {

        Circle [] circles=new Circle[2];
        circles[0]=new Circle(1);
        circles[1]=new Circle(2);
        for (Circle circle1: circles) {

            System.out.println(circle1);
            System.out.println("Diện tích trước khi tăng: "+circle1.getPerimeter());
            double percent=(Math.random()*100)+1;
            circle1.resize(percent);
            System.out.println(circle1);
            System.out.println("Diện tích sau khi tăng: "+circle1.getPerimeter());

        }
    }
}