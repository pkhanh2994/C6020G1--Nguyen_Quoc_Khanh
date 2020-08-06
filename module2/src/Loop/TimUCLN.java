package Loop;
import java.util.Scanner;
public class TimUCLN {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a;
        int b;
        System.out.print("Nhập vào số a:\t");
        a=scanner.nextInt();
        System.out.print("Nhập vào số b:\t");
        b=scanner.nextInt();
        while (b!=0){
            int tam;
            tam=a%b;
            a=b;
            b=tam;
        }
        System.out.println("Greatest common factor: " + a);


    }

}
