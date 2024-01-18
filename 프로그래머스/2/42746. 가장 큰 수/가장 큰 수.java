import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Solution {
       public static String solution(int[] numbers) {

        String[] numberToString = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(numberToString, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (numberToString[0].equals("0")) {
            return "0";
        }

        return String.join("", numberToString);
    }

//테스트 케이스 

    @DisplayName("숫자들을 이어붙여서 가장 큰 수가 나오도록 할 수 있다.")
    @Test
    void test1(){
        //given
        int[] numbers = {34, 4, 5};
        String expected = "5434";

        //when
        String actual = solution(numbers);

        //then
        assertThat(actual).isEqualTo(expected);

    }

    @DisplayName("숫자들을 이어붙여서 가장 큰 수가 나오도록 할 수 있다.(오답)")
    @Test
    void test2(){
        //given
        int[] numbers = {34, 4, 5};
        String expected = "5344";

        //when
        String actual = solution(numbers);

        //then
        assertThat(actual).isNotEqualTo(expected);

    }

    @DisplayName("중복 숫자들을 이어붙여서 가장 큰 수가 나오도록 할 수 있다.")
    @Test
    void test3(){
        //given
        int[] numbers = {4, 4, 4, 4, 4};
        String expected = "44444";

        //when
        String actual = solution(numbers);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("오름차순 정렬된 숫자들을 이어붙여서 가장 큰수를 만들 수 있다.")
    @Test
    void test4(){
        //given
        int[] numbers = {1, 2, 3, 4, 5};
        String expected = "54321";

        //when
        String actual = solution(numbers);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자가 0만 있을 때 '0'을 반환한다.")
    @Test
    void test5(){
        //given
        int[] numbers = {0, 0 , 0, 0};
        String expected = "0";

        //when
        String actual = solution(numbers);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자에 0이 있어도 가장 큰 수를 만들 수 있다.")
    @Test
    void test6(){
        //given
        int[] numbers = {5, 3 , 43, 0};
        String expected = "54330";

        //when
        String actual = solution(numbers);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("null 예외처리를 할 수 있다.")
    @Test
    void test7(){
        //given
        int[] numbers = null;
        //then
        assertThatThrownBy(()->solution(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 null일 수 없습니다.");

}
    @DisplayName("많은 숫자들을 이어붙여서 가장 큰수를 만들 수 있다.")
    @Test
    void test8(){
        //given
        int[] numbers = new int[100000];

        for(int i =0; i<numbers.length; i++){
            numbers[i]= i%1000;

        }
        //when
        String actual = solution(numbers);
        char expectedFirstChar = '9'; // 가장 큰 숫자는 999, 따라서 문자열의 첫 번째 문자는 '9'이어야 함
        assertThat(actual.charAt(0)).isEqualTo(expectedFirstChar);


    }
}
