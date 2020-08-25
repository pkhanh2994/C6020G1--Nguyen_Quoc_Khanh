package exceptionanddebug.bai_tap;

import java.util.Scanner;

public class TriangleRuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            TriangleRuntime triangleRuntime = new TriangleRuntime();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the side of triangle");
            System.out.println("Enter the side 1");
            int side1 = scanner.nextInt();
            triangleRuntime.setSide1(side1);
            System.out.println("Enter the side 2");
            int side2 = scanner.nextInt();
            triangleRuntime.setSide2(side2);
            System.out.println("Enter the side 3");
            int side3 = scanner.nextInt();
            triangleRuntime.setSide3(side3);
            triangleRuntime.getPremiter();
        } catch (TriangleRuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
