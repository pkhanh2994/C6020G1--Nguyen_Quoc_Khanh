package array_and_fuction.bai_tap;
import java.util.Arrays;
import java.util.Scanner;

public class ChenPhanTuVaoMang {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9,0,0,0};
        int doDai=arr.length;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phần tử cần chèn\t");
        int x = scanner.nextInt();
        System.out.print("Nhập vào vị trí cần chèn\t");
        int viTri=scanner.nextInt();
        if(viTri<1||viTri>doDai-1){
            System.out.println("Không thể chèn vào số\t"+x);
        }else{
            for(int i=doDai-1;i>=viTri;i--){
                arr[i]=arr[i-1];
            }
            arr[viTri]=x;

        }
        System.out.println("mảng sau khi thêm vào là\t"+ Arrays.toString(arr));
    }
}
