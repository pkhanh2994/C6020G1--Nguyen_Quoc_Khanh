package stackandqueue.bai_tap;

import java.util.Stack;

public class KiemTraDauNgoac {
   public static boolean checkParentesis(String string){
       if(string.isEmpty()){
           return true;
       }
       Stack<Character>stack=new Stack<>();
       for(int i=0; i<string.length();i++){
           char sym=string.charAt(i);
           if(sym=='{'||sym=='('||sym=='['){
               stack.push(sym);
           }
           if(sym=='}'||sym==')'||sym==']'){
               if(stack.empty()){
                   return false;
               }
               char behind = stack.peek();
               if(sym=='}'&&behind=='{'||sym==')'&&behind=='('||sym==']'&& behind=='['){
                   stack.pop();
               }else return false;
           }
           }

       return stack.empty();
    }

}
