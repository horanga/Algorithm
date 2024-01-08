import java.util.*;

class Solution {
  static boolean solution(String s) {

        if(s==null && s.length()%2!=0){//(와 )가 한 세트씩 필요하기 때문에 String의 길이는 2의 배수여야 한다.
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();//stack이 비어있지 않다면 '('나 ')'처럼 짞이 없는 괄호들이 남아있다는 뜻
    }
}
