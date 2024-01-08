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

  //테스트 코드

  @Test
    void 정상_작동(){
        //given
        String input ="(())()((()))";

        //when
        boolean actual = solution(input);

        //then

        Assertions.assertTrue(actual);
    }

    @Test
    void 정상_작동_오답(){
        //given
        String input ="((((((((";

        //when
        boolean actual = solution(input);

        //then

        Assertions.assertFalse(actual);
    }

    @Test
    void 빈문자열(){
        //given
        String input ="";

        //when
        boolean actual = solution(input);

        //then

        Assertions.assertTrue(actual);
    }

    @Test
    void String_null값(){
        //given
        String input =null;

        //when
        boolean actual = solution(input);

        //then

        Assertions.assertFalse(actual);
    }

    @Test
    void 잘못된_괄호순서(){
        //given
        String input =")(";

        //when
        boolean actual = solution(input);

        //then

        Assertions.assertFalse(actual);
    }

    @Test
    void 다른_문자열(){
        //given
        String input ="(a)";

        //when
        boolean actual = solution(input);

        //then

        Assertions.assertFalse(actual);
    }

    @Test
    void 긴_문자열(){
        //when
        String input ="(())(())()".repeat(1000);

        //boolean
        long startTime = System.nanoTime();
        boolean actual = solution(input);
        long endTime = System.nanoTime();

        //then
        Assertions.assertTrue(actual);

        // 시간 출력 (나노초에서 밀리초로 변환)
        System.out.println("실행 시간: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
