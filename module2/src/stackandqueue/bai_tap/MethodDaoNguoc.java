package stackandqueue.bai_tap;

import java.util.Stack;

public class MethodDaoNguoc {
    int[] arr = new int[5];
    String string="";
    Stack<Integer> stack = new Stack<>();
    Stack<Character>stackChuoi=new Stack<>();

    public MethodDaoNguoc(int[] arr) {
        this.arr = arr;
    }
    public MethodDaoNguoc(String string){
        this.string=string;

    }
    public void choVao() {
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
    }
    public void choVaoChuoi(){
        for(int i=0;i<string.length();i++){
            stackChuoi.push(string.charAt(i));
        }
    }
    public int[]layRa(){
        for(int i=0;i<arr.length;i++){
            arr[i]=stack.pop();
        }
        return arr;
    }
    public String layRaChuoi(){
        StringBuilder chuoiMoi= new StringBuilder();
        for(int i=0;i<string.length();i++){
            chuoiMoi.append(stackChuoi.pop());
        }
        return chuoiMoi.toString();
    }
}
