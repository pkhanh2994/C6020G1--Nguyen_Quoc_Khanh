package array_and_fuction.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuTrongMang {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 6,6,6,9};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phần tử cần xóa\t");
        int x = scanner.nextInt();
        int viTri;
        int dem = 0;
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                dem++;
                viTri = i;
                if (dem > 0) {
                    for (int j = viTri; j < arr.length-1; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[arr.length - 1] = 0;
                    i--;
                }

            }
        }
        String res = Arrays.toString(arr);
        System.out.print("sau khi xóa:\t" + res);

    }

}
