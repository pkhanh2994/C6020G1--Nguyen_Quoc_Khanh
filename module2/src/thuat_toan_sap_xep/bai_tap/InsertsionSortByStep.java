package thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class InsertsionSortByStep {
    public static void  insertSort(int[] arr) {
        boolean needNextPass=false;
        for (int i = 1; i < arr.length; i++) {
            System.out.println("insert "+arr [i]+" into a sorted sublist");
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            System.out.println("insert the temp into "+ arr[j+1]);
            arr[j + 1] = temp;
            needNextPass = true;

            if (!needNextPass) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            System.out.print("List after the  " + i + "' sort: ");
            for (int value : arr) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of array");
        int nums = scanner.nextInt();
        int[] array = new int[nums];
        for (int i = 0; i < nums; i++) {
            System.out.println("Enter the element of array");
            array[i] = scanner.nextInt();
        }
        System.out.println("The array before sort");
        System.out.println(Arrays.toString(array));
       insertSort(array);
    }
}
