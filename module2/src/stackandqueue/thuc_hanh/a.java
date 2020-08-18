package stackandqueue.thuc_hanh;

import java.util.ArrayList;

public class a {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer>arrayList1=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(2);

        Integer a = 2;
        Integer b = 2;
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(2);

//        arrayList.clear();
        System.out.println(arrayList.containsAll(arrayList1));
        System.out.println(arrayList);
        System.out.println(arrayList1);
    }
}
