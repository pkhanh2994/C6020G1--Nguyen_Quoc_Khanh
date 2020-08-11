package OOP.interfaceandabtrasct.bai_tap;

public class Square2Test {
    public static void main(String[] args) {
        Shape[]shapes=new Shape[3];
        shapes[0]=new Circle(1);
        shapes[1]=new Rectangle(2,3);
        shapes[2]=new Square2(4);
        for(Shape shape:shapes){
            if(shape instanceof Square2){
                Colorable colorable=(Square2) shape;
                colorable.howToColorable();
            }
            System.out.println(shape);
        }
    }
}
