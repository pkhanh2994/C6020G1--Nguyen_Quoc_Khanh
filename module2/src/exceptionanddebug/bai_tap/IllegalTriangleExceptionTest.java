package exceptionanddebug.bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;
public class IllegalTriangleExceptionTest {
    public static void main(String[] args) {
        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the side of triangle");
            System.out.println("Enter the side 1");
            int side1=scanner.nextInt() ;
            if(side1<=0)
                throw new IllegalTriangleException();
            System.out.println("Enter the side 2");
            int side2=scanner.nextInt() ;
            if(side2<=0)
                throw new IllegalTriangleException();
            System.out.println("Enter the side 3");
            int side3=scanner.nextInt() ;
            if(side3<=0)
                throw new IllegalTriangleException();
            if((side1+side2<side3)||(side1+side3<side2)||(side2+side3<side1))
                throw new IllegalTriangleException();
            System.out.printf("The sides of triangle:  %d,%d,%d",side1,side2,side3);
        }catch (IllegalTriangleException e){
        System.out.println("This is not the side of triangle or  the side of the triangle must be positive and greater than 0");
    }
        catch (InputMismatchException e){
            System.out.println("The length of the triangle side must be a number");
        }
        }
}
