package casejame;

import java.io.Serializable;
import java.util.Scanner;

public class Controller implements Serializable {
    public static Scanner scanner = new Scanner(System.in);

    public static void dieuKhien() {
        boolean kiemTra = true;
        do {
            System.out.println("Lựa chọn chức năng của từ điển:\n" + "1.Hiển thị danh sách từ có trong từ điển\n" +
                    "2.Chức năng:thêm(define),xóa(drop),tìm kiếm từ(lookup),in ra file text(export +tên file)\n" + "3.Thoát");
            String chon1 = scanner.nextLine();
            switch (chon1) {
                case "1":
                    Request.hienThi();
                    break;
                case "2":
                    Request request = new Request();
                    String action;
                    do {
                        System.out.println("Nhập lựa chọn của bạn");
                        action = scanner.nextLine();
                    } while (!action.matches("^((lookup)|(define)|(drop)|(export))\\s\\D+$"));
                    String[] chon;
                    chon = action.split("\\s");
                    request.setAction(chon[0]);
                    request.setKeyword(chon[1]);
                    request.checkAction();
                    break;
                case "3":
                    kiemTra = false;
                    break;

            }
        } while (kiemTra);
    }
}
