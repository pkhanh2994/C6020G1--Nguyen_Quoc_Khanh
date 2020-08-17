package stackandqueue.bai_tap;

import java.util.Scanner;

public class MainDemicial {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số cần chuyển đổi");
        int nums=scanner.nextInt();
        Demicial demicial=new Demicial();
        System.out.println("Hệ nhị phân của sô "+nums+" là: ");
        demicial.covert(nums);
    }

}
