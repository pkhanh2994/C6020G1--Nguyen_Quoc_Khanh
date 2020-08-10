package OOP.thuc_hanh;

//public class MyClass {
//    static int count = 1;
//
//
//    MyClass() {
//        count++;
//        System.out.println(count);
//    }
////Nó cứ tăng lên thoải mái không liên quan gì tới thèn đối tượng hết
//    public static void main(String args[]) {
//        MyClass c1 = new MyClass();
//        MyClass c2 = new MyClass();
//        MyClass c3 = new MyClass();
//        MyClass.count = 2;
//        System.out.printf("x=%d, y=%d, z=%d", c1.count, c2.count, c3.count);
//        //nó gán cmn 2 cho đối tượng c1,c2,c3 xong in cmn ra luôn là 222 nhé
//    }
//}
public class SinhVien {

    private String ten;
    private String tuoi;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        if (ten == null || ten.isEmpty()) {
            // Nếu biến ten chưa khởi tạo (mang giá trị null), hoặc biến ten có nội dung rỗng
            // Thì hãy lưu với tên là "Không biết"
            this.ten = "Không biết";
        } else {
            this.ten = ten;
        }
        this.ten=ten;
    }

    public String getTuoi() {
        if (Integer.valueOf(tuoi) != -1) {
            // Tuổi hợp lệ
            return tuoi;
        } else {
            return "Tuổi không hợp lệ";
        }
    }

    public void setTuoi(int tuoi) {
        // Kiểm tra tuổi có hợp lý hay không, nếu hợp lý thì lưu vào, nếu không sẽ tìm cách báo lỗi bằng cách lưu giá trị âm
        if (tuoi > 18) {
            this.tuoi = String.valueOf(tuoi);
        } else {
            this.tuoi = String.valueOf(-1);
        }
    }

}