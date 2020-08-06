package array_and_fuction.bai_tap;
import java.util.Scanner;

public class TimMax {
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
        int max=matrix[0][0];
        for(int row=0;row<matrix.length;row++){
            for(int column=0;column<matrix[row].length;column++){
                if(max<matrix[column][row]){
                    max=matrix[column][row];
                }
            }
        }
        System.out.println("Phần tử lớn nhất là\t"+max);
    }
}
