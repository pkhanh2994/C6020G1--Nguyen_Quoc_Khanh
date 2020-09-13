package thuat_toan_sap_xep.thuc_hanh;

public class Test {
    void a(){
        b();
    }
    public static void b(){
        System.out.println("b");
    }
    public static void main(String[] args) {
        Test test=new Test();

        test.a();
    }
}
