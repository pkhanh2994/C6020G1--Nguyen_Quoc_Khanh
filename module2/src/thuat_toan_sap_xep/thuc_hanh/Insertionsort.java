package thuat_toan_sap_xep.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class Insertionsort {
    public static int[]insertSort(int[]arr,int nums){
        for(int i=1;i<nums;i++){
            int temp=arr[i];
            int j=i-1;
            while (j>=0 && temp<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
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
        System.out.println("The array after ascending sorted");
        System.out.println(Arrays.toString(insertSort(array, nums)));
    }
}
