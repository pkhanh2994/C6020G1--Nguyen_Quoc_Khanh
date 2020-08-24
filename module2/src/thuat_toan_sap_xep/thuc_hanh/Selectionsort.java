package thuat_toan_sap_xep.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class Selectionsort {

    public static int[] selectSort(int[] arr, int nums) {
        int min;
        for (int i = 0; i <nums-1; i++) {

            min = i;
            for (int j = i + 1; j < nums; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min!=i){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
        return arr;

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
        System.out.println("The array after  ascending sorted");
        System.out.println(Arrays.toString(selectSort(array, nums)));


    }
}
