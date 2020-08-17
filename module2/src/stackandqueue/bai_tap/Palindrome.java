package stackandqueue.bai_tap;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập chuỗi cần kiểm tra");
        String string=scanner.nextLine();
        Queue queue=new ArrayDeque();
        for(int i=string.length()-1;i>=0;i--){
            queue.add(string.charAt(i));
        }
        String reverseString="";
        while (!queue.isEmpty()){
            reverseString+=queue.remove();
        }
        if(string.equals(reverseString)){
            System.out.println("The string is a palindrome");
        }else {
            System.out.println("The string is not a palindrome");
        }

    }
}
