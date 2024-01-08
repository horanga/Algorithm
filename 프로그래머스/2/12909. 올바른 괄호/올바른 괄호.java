import java.util.*;

class Solution {
  static boolean solution(String s) {

        if(s==null||s.length()%2!=0){
            return false;
        }


        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            switch (ch){
                case '(':
                stack.push(ch);
                break;

                case ')':
                    if (stack.isEmpty()) {
                    return false;
                    }
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
