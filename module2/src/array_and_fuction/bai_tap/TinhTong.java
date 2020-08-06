package array_and_fuction.bai_tap;
import java.util.Scanner;
public class TinhTong {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int sizeRow;
        System.out.print("nhập vào số hàng\t");
        sizeRow=input.nextInt();
        int sizeColumn;
        System.out.print("Nhập vào số cột\t");
        sizeColumn=input.nextInt();
        int[][] matrix = new int[sizeRow][sizeColumn];
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
        System.out.println("nhập cột muốn tính tổng");
        int nums=input.nextInt();
        int total = 0;
        for (int i= 0; i< matrix.length; i++) {
          total+=matrix[i][nums];
            }

        System.out.println("Tổng của cột "+nums+" là "+total);
    }
}
