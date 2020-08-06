package array_and_fuction.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class GopHaiMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        int[] arr3 = new int[10];
        int i = 0;
        int j = 0;
        int l = 0;
        //khởi tạo mảng arr1
        while (i < arr1.length) {
            System.out.print("Enter element of arr1 " + (i + 1) + ": ");
            arr1[i] = scanner.nextInt();
            i++;
        }
        System.out.printf("%-20s%s", "Elements in arr1: ", "");
        for (int m = 0; m < arr1.length; m++) {
            System.out.print(arr1[m] + "\t");
        }
        System.out.println("");
        //Khởi tạo mảng arr2
        while (j < arr2.length) {
            System.out.print("Enter element of arr2 " + (j + 1) + ": ");
            arr2[j] = scanner.nextInt();
            j++;
        }
        System.out.printf("%-20s%s", "Elements in arr2: ", "");
        for (int k = 0; k < arr2.length; k++) {
            System.out.print(arr2[k] + "\t");
        }
        //gộp hai mảng arr1 và arr2 vào arr3
        for (i = 0; i < arr1.length; i++) {
            arr3[l] = arr1[i];
            l++;
        }
        for (j = 0; j < arr2.length; j++) {
            arr3[l] = arr2[j];
            l++;
        }
        System.out.println(Arrays.toString(arr3));
    }
}
//for (int j = 0; j < array.length; j++) {
//        System.out.print(array[j] + "\t");
//        }