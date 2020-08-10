package OOP.bai_tap;

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint=new MoveablePoint(2,3,1,2);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
