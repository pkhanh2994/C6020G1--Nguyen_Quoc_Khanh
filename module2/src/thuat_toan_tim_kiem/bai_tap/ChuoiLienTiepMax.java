package thuat_toan_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class ChuoiLienTiepMax {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        LinkedList<Character>list=new LinkedList<>();
        LinkedList<Character>max=new LinkedList<>();
        System.out.println("Enter the string");
        String string=scanner.nextLine();
        for(int i=0;i<string.length();i++){
            if(list.size()>1&&string.charAt(i)<=list.getLast()&&list.contains(string.charAt(i))){
                list.clear();
            }
            list.add(string.charAt(i));
            if(list.size()>max.size()){
                max.clear();
                max.addAll(list);
            }
        }
        for(Character character:max){ 
            System.out.print(character);
        }
    }
    /*********************************************************************************
     * 	Analyze the time complexity of your program:                                  *
     * 	1 single loop * 3 simple statements = 3;                                      *
     * 	1 single loop * 1 simple statement = 1;                                       *
     *                                                                                *
     * 	T(n) = O(n) Linear time;                                                      *
     *********************************************************************************/
}
