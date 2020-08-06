package array_and_fuction.bai_tap;

import java.util.Scanner;

public class TinhTongDuongCheo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sizeRow;
        System.out.print("nhập vào số hàng\t");
        sizeRow = input.nextInt();
        int sizeColumn;
        System.out.print("Nhập vào số cột\t");
        sizeColumn = input.nextInt();
        int[][] matrix = new int[sizeRow][sizeColumn];
        if (sizeColumn != sizeRow) {
            System.out.print("Hãy nhập số hàng bằng số cột để tạo thành ma trận vuông");
            ;
        } else {
            System.out.println("Enter " + matrix.length + " rows and " +
                    matrix[0].length + " columns: ");
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    matrix[row][column] = input.nextInt();
                }
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    System.out.print(matrix[row][column] + " ");
                }
                System.out.println();
            }
            int sum = 0;
            for(int i=0;i<matrix.length;i++){
                sum+=matrix[i][i];
            }
            System.out.println("Tổng đường chéo của ma trận là:\t"+sum);
        }
    }
}
