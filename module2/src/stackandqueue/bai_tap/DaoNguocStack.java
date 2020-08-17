package stackandqueue.bai_tap;

import java.util.Arrays;

public class DaoNguocStack {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        MethodDaoNguoc methodDaoNguoc=new MethodDaoNguoc(arr);
        methodDaoNguoc.choVao();
        methodDaoNguoc.layRa();
        System.out.println(Arrays.toString(arr));
        String string="LoveYou";
        MethodDaoNguoc methodDaoNguocChuoi=new MethodDaoNguoc(string);
        methodDaoNguocChuoi.choVaoChuoi();
        System.out.println( methodDaoNguocChuoi.layRaChuoi());

    }

}
