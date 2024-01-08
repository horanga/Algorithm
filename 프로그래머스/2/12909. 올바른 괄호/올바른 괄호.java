import java.util.*;

class Solution {
 boolean solution(String s) {
       
        
      Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch==')'&&stack.isEmpty()){
                return false;
            } else if(ch==')'&& stack.peek()=='('){
                stack.pop();
            } else {

                stack.push(ch);
            }
        }


        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}