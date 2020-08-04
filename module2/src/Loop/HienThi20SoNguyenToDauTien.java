package Loop;
import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng số nguyên tố cần in ra");
        int nums = scanner.nextInt();
        int count = 0;
        int n = 2;
        while (count <= nums) {
            int check = 0;
            for (int i = 3; i <n; i++) {
                if (n % i == 0) {
                    check++;
                }
            }
            if (check ==0) {
                System.out.print(n + "\t");
                count++;
            }
            n++;
        }
    }
}

