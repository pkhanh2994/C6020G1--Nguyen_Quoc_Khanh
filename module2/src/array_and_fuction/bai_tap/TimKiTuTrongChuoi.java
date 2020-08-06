package array_and_fuction.bai_tap;
import java.util.Scanner;

public class TimKiTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào chuỗi ");
        String str=scanner.nextLine();
        System.out.println("Nhập vào kí tự cần kiểm tra");
        char x;
        x=scanner.next().charAt(0);
        int count=0;
        for(int i=0;i<str.length();i++){
            if(x==str.charAt(i)){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của kí tự "+x+" trong chuỗi "+str+" là:\t"+count);


    }
}
