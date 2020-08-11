package OOP.interfaceandabtrasct.bai_tap;

public class RectangleTest {
    public static void main(String[] args) {

        Rectangle[]rectangles=new Rectangle[2];
        rectangles[0]=new Rectangle(1,3);
        rectangles[1]=new Rectangle(2,3);
        for(Rectangle rectangle1: rectangles){
            System.out.println("Diện tích trước khi tăng: "+rectangle1.getPerimeter());
            double percent=((Math.random()*100)+1);
            rectangle1.resize(percent);
            System.out.println(rectangle1);
            System.out.println("Diện tích sau khi tăng: "+rectangle1.getPerimeter());
        }
    }
}
