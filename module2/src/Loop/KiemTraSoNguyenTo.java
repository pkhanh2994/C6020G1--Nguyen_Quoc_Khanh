package Loop;
import java.util.Scanner;
public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số cần kiểm tra");
        int nums=scanner.nextInt();
        int count=0;
        if(nums<2){
            System.out.println(nums+"\tkhông phải là số nguyên tố");
        }
        for (int i=2;i<nums;i++){
            if(nums%i==0){
                count++;
            }
        }
        if(count==0){
            System.out.println(nums+"\tlà số nguyên tố");
        }else {
            System.out.println(nums+"\tkhông phải là số nguyên tố");
        }
    }
}
