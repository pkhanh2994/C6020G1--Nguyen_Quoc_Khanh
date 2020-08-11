package OOP.interfaceandabtrasct.bai_tap;

public class SquareTest {
    public static void main(String[] args) {
        Square[] squares = new Square[2];
        squares[0] = new Square(1);
        squares[1] = new Square(2);
        for (Square square : squares) {
            System.out.println("Diện tích trước khi tăng của hình vuông "+square+"là: "+square.getPerimeter());
            double percent=(Math.random()*100)+1;
            square.resize(percent);
            System.out.println("Diện tích sau khi tăng: "+square.getPerimeter());
        }

    }
}
