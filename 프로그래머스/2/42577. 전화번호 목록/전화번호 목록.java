public class Solution {

import java.util.HashSet;
import java.util.Set;

public class Solution {


        public static boolean solution(String[] phone_book) {


        Set<String> phoneNumberSet = new HashSet<>();
        for(String phone: phone_book){
           if (phone!=null) {
            phoneNumberSet.add(phone);
           }
        }

        //substring(startIndex, endIndex)는 startIndex부터 endIndex-1까지를 반환한다. 그래서, 시작점은 j=1로 잡아주었다. 
        for(String phone: phone_book){
            for(int j =1; j<phone.length(); j++)
                if(phoneNumberSet.contains(phone.substring(0, j)))
                    return false;
            }
        return true;

//테스트코드 
    @Test
    void 정확성검사(){
        //given
        String[] input = {"010222", "010", "112", "222"};
        boolean expected = false;
        //when
        boolean actual = solution(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
}

    @Test
    void 정확성검사_오답(){
        //given
        String[] input = {"010222", "102", "222"};
        boolean expected = false;
        //when
        boolean actual = solution(input);

        //then
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void 중복번호_검사(){
        //given
        String[] input = {"111111111111", "11"};
        boolean expected = false;
        //when
        boolean actual = solution(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 번호한개(){
        //given
        String[] input = {"111111111111"};
        boolean expected = true;
        //when
        boolean actual = solution(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 빈배열(){
        //given
        String[] input = {};
        boolean expected = true;
        //when
        boolean actual = solution(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    @Test
    void 많은_번호(){
        //given
        String[] input = new String[100000];
        for(int i = 1; i < input.length - 1; i++) {
            // 간소화된 무작위 전화번호 생성: 8자리 숫자
            input[i] = String.valueOf((int)(Math.random() * 100000000));
        }

        input[0]="12345678";
        input[99999]="12345678";

        boolean expected = false;
        //when
        boolean actual = solution(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 엣지케이스(){
        //given
        String[] input = {"12344", "12356", "345"};
            //123이 공통되지만 둘다 서로의 접두어는 아닌 사례

        boolean expected = true;
        //when
        boolean actual = solution(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
        }
}
