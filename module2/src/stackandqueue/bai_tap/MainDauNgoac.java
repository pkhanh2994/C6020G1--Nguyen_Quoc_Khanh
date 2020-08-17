package stackandqueue.bai_tap;

import java.util.Scanner;

public class MainDauNgoac {
    public static void main(String[] args) {
        KiemTraDauNgoac kiemTraDauNgoac=new KiemTraDauNgoac();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập biểu thức cần kiểm tra");
        String string=scanner.nextLine();
        System.out.println(KiemTraDauNgoac.checkParentesis(string));

    }

}
