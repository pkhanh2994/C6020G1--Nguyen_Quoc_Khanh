package casejame;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Request {
    private String action;
    private static LinkedList<Entities> params;
    private String keyword;
    private Scanner scanner = new Scanner(System.in);
    public static final String DICTIONARY = "C:\\C0620G1- Nguyen Quoc Khanh\\module2\\src\\casejame\\data\\dictionary.txt";

    public Request() {
        params = new LinkedList<>();
    }

    public Request(String action, LinkedList<Entities> params, String keyword) {
        this.action = action;
        this.params = params;
        this.keyword = keyword;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LinkedList<Entities> getParams() {
        return params;
    }

    public void setParams(LinkedList<Entities> params) {
        this.params = params;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void checkAction() {
        try {
            params = ReadWritefile.readFile(DICTIONARY);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (this.action.equals("lookup")) {
            looKup();
        } else {
            if (this.action.equals("define")) {
                define();
            } else if (this.action.equals("drop")) {
                drop();
            }else if(this.action.equals("export")){
                export();
            }
        }
    }

    private void looKup() {
        boolean isCheck = true;
        if (params.size() != 0) {
            for (Entities entities : params) {
                if (entities.getKeyword().equals(this.keyword)) {
                    System.out.println(entities.toString());
                    isCheck = false;
                }
            }
        }
        if (isCheck) {
            System.out.println("Không tồn tại từ bạn tìm kiếm");
        }
    }

    private void define() {
        Entities entities = new Entities();
        String type = null;

        do {
            System.out.println("Từ này loại gì");
            type = scanner.nextLine();

        } while (!type.matches("^((noun)|(verb)|(adj))$"));
        entities.setTypeWord(type);
        if (params.size() != 0) {
            for (Entities entities1 : params) {
                if (entities1.getKeyword().equals(this.keyword) && entities1.getTypeWord().equals(entities.getTypeWord())) {
                    System.out.println("Từ này đã tồn tại"+entities1);
                    return;
                }
            }
        }
        String meaning;
        System.out.println("Nhập định nghĩa cho từ");
        meaning = scanner.nextLine();
        entities.setMeaning(meaning);
        entities.setKeyword(this.keyword);
        params.add(entities);
        try {
            ReadWritefile.writeFile(params, DICTIONARY);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void drop() {
        Entities entities=null;
        boolean kiemTra=true;
        if (this.params.size() == 0) {
            System.out.println("Từ điển hiện đang trống");
        } else {
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i).getKeyword().equals(this.keyword)) {
                    entities=params.get(i);
                    params.remove(entities);
                    kiemTra=false;
                }
            }
            if(kiemTra){
                System.out.println("Không có từ để xóa");
            }else {
                System.out.println("Đã xóa từ");
            }
        }
        try {
            ReadWritefile.writeFile(params, DICTIONARY);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void hienThi() {
        try {
            params=ReadWritefile.readFile(DICTIONARY);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (params.size() != 0) {
                System.out.println("Các từ có trong từ điển hiện tại là");
                for (Entities entities : params) {
                    System.out.println(entities.getKeyword());
                }
            }else
            System.out.println("Từ điển hiện đang trống, hãy bổ sung từ mới ");
        }
    private  void export() {
        try {
            params = ReadWritefile.readFile(DICTIONARY);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (params.size() == 0) {
            System.out.println("Từ điển trống, không thể sao chép ra file text");
        } else {
            String file = this.keyword;
            String[] arr = params.toString().split("");
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            try {
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < arr.length; i++) {
                    bufferedWriter.write(arr[i]);
                    if (i != arr.length) {
                        bufferedWriter.append("");
                    } else bufferedWriter.append("\n");
                }
                System.out.println("Exporting 10%..20%..30%..40%..50%..60%..70%..80%..90%..Done!");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
