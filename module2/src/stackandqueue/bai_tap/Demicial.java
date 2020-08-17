package stackandqueue.bai_tap;

import java.util.Stack;

public class Demicial {
    public void covert(int nums) {
        Stack<Integer> stack = new Stack<>();
        while ((nums != 0)) {
            int soNhiPhan;
            soNhiPhan=nums%2;
            stack.push(soNhiPhan);
            nums/=2;
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
    }
}
