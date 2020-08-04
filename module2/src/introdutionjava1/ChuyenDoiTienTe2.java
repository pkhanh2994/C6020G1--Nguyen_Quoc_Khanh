package introdutionjava1;
import java.util.Scanner;
public class ChuyenDoiTienTe2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rate;
        double USD;
        System.out.println("Enter rate:");
        rate = scanner.nextDouble();
        System.out.println("Enter USD:");
        USD = scanner.nextDouble();
        double change = USD * rate;
        System.out.print("Số tiền quy đổi ra VND là:\t" + change);
    }
}