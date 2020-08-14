package listinjava.bai_tap;

import java.util.Arrays;

public class MyListTest1 {
    public static void main(String[] args) {
        MyList1<Integer> listInteger1 = new MyList1<Integer>();
        listInteger1.add(1);
        listInteger1.add(2);
        listInteger1.add(3);
        listInteger1.add(4);
        listInteger1.add(5);
        listInteger1.addIndex(2, 4);
        System.out.println(listInteger1.get(0));
        System.out.println(listInteger1.get(1));
//        listInteger1.remove(2);
        System.out.println(listInteger1.get(2));
        System.out.println(listInteger1.get(3));
        System.out.println(listInteger1.get(4));
        System.out.println(listInteger1.get(5));
        System.out.println(listInteger1.contains(2));
        System.out.println(listInteger1.indexOf(1));
        System.out.println(Arrays.toString(listInteger1.clone()));


    }

}
