package introdutionjava1;
import java.util.Scanner;
public class RectangleProgram2 {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter width:\t");
        width = scanner.nextFloat();

        System.out.println("Enter height:\t");
        height =scanner.nextFloat();

        float area=width*height;
        System.out.println("The area is:\t"+area);

    }
}