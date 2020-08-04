package introdutionjava1;

import java.util.Scanner;
public class HelloFriend2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter your name:\t");
        String name=scanner.nextLine();

        System.out.print("Hello my friend:\t"+name);

    }
}
